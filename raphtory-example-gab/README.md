# Gab Example

This example demonstrates an analysis used to study the evolution of the Gab Social network. 
The work from this project was published in the academic paper titled `Moving with the times: Investigating the alt right network Gab using temporal interaction graphs”`

## Usage

1. Create a lib directory and import Raphtory jar.

    ```sh
   $ mkdir lib
   $ wget https://github.com/Raphtory/Raphtory/releases/download/0.3.0/Raphtory.0.3.0.jar lib/raphtory.jar
    ```

2. Set the following environment variables

   `FILE_SPOUT_DIRECTORY` - Location of the source file e.g. `FULL PATH/data/`
      
   `FILE_SPOUT_FILENAME` - Source file name e.g. `gabNetwork500.csv`

   `FILE_SPOUT_DROP_HEADER` - Set tp `true` to ignore the header file

3. Run the analysis

    ```sh
    $ sbt run
    ```

## Results

This will run a connected component query over the selected time windows 
and return all the results as shown below

   ```json
   {"proportion":0.0,"clustersGT2":0,"windowsize":31536000000,"totalIslands":0,"total":0,"top5":[0],"viewTime":54,"time":1470797917000}
   {"proportion":0.0,"clustersGT2":0,"windowsize":2592000000,"totalIslands":0,"total":0,"top5":[0],"viewTime":5,"time":1470797917000}
   {"proportion":0.0,"clustersGT2":0,"windowsize":604800000,"totalIslands":0,"total":0,"top5":[0],"viewTime":5,"time":1470797917000}
   ...
   {"proportion":0.96794873,"clustersGT2":5,"windowsize":604800000,"totalIslands":0,"total":32,"top5":[2114,6,4,3,3],"viewTime":79,"time":1475895517000}
   ```


## IntelliJ setup guide

As of 20th Sept. This is a guide to run this within intellij 

1. From https://adoptopenjdk.net/index.html download/install OpenJDK 11 (LTS) with the HotSpot VM
2. Enable this as the project SDK under File > Project Structure > Project Settings > Project > Project SDK
3. Create a new configuration as an `Application` , select Java 11 as the build, and 
`com.raphtory.examples.gab.Runner` as the class, add the Environment Variables also

