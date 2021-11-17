# Gab Example

This example demonstrates an analysis used to study the evolution of the Gab Social network. 
The work from this project was published in the academic paper titled `Moving with the times: Investigating the alt right network Gab using temporal interaction graphs”`

## Usage

1. Create a lib directory and import Raphtory jar.

    ```sh
   $ mkdir lib
   // download the latest from https://github.com/Raphtory/Raphtory/releases/latest
    ```

2. Run the analysis

    ```sh
    $ sbt run
    ```

## Results

This will run a connected component query over the selected time windows. 
The results will be saved to `/tmp/connectedComponents`

   ```json
   1473130717000,31536000000,7845,1
   1473130717000,31536000000,3117,1
   1473130717000,31536000000,2453,1
   1473130717000,31536000000,4741,1
   ```

## IntelliJ setup guide

As of 17th Nov. This is a guide to run this within intellij 

1. From https://adoptopenjdk.net/index.html download/install OpenJDK 11 (LTS) with the HotSpot VM
2. Enable this as the project SDK under File > Project Structure > Project Settings > Project > Project SDK
3. Create a new configuration as an `Application` , select Java 11 as the build, and 
`com.raphtory.examples.gab.Runner` as the class, add the Environment Variables also

