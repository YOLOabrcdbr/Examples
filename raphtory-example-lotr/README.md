# LOTR Example

This example builds a temporal graph and runs a query to tell us when two characters show up at the
same time in the Lord of the Rings books.

The data is a `csv` file (comma-separated values) is located in the `data` folder. 
Each line contains two characters that appeared in the same sentence in the 
book, along with which sentence they appeared as indicated by a number. 
In the example, the first line of the file is `Gandalf,Elrond,33` which tells
us that Gandalf and Elrond appears together in sentence 33.

Also, in the examples folder you will find `LOTRSpout.scala`, `LOTRGraphBuilder.scala`
and `Runner.scala`.

* `Runner.scala` runs the application including the analysis
* `LOTRSpout.scala` ingests the data into a graph
* `LOTRGraphBuilder.scala` builds the graph
* `LOTRSixDegreesAnalyser` analysis to identify characters and crossed paths

For a detailed writeup about this example please refer to the [documentation](https://raphtory.github.io/documentation/sprouter)

## Usage

1. Create a lib directory and import Raphtory jar.

    ```sh
   $ mkdir lib
   $ wget https://github.com/Raphtory/Raphtory/releases/download/0.3.0/Raphtory.0.3.0.jar lib/raphtory.jar
    ```

2. Set the following environment variables 

   `FILE_SPOUT_DIRECTORY` - Location of the source file e.g. `absolute path/raphtory-example-lotr/src/main/scala/com/raphtory/examples/lotr/data`

   `FILE_SPOUT_FILENAME`  - Source file name e.g.  `lotr.csv`
   
   `FILE_SPOUT_DROP_HEADER` - Set tp `false` to include the header file 

5. Run the analysis

    ```sh
    $ sbt run
    ```

## Results

We can see an Implemented version of the SixDegrees
over all pages. Running this on line 5000 of the books, returns the following JSON data.

When running the terminal should produce a message similar to this. indidicating that it has received a request to perform an analysis 

```scala
14:14:13.184 [Raphtory-akka.actor.default-dispatcher-16] INFO  c.r.c.a.a.AnalysisManager - Range Analysis Task received, your job ID is com.raphtory.algorithms.ConnectedComponents_1632143653184, running com.raphtory.algorithms.ConnectedComponents, between 1 and 32674 jumping 1000 at a time.
14:14:13.190 [Raphtory-akka.actor.default-dispatcher-13] INFO  c.r.c.a.a.AnalysisManager - View Analysis Task received, your job ID is com.raphtory.examples.lotr.analysis.LOTRSixDegreesAnalyser_1632143653190
```

The terminal should then produce the following result

```json
{"time":5000,"viewTime":274,"total":24,"direct":9}
```

This data tells us that there are a total of 24 nodes: 14 nodes are connected to the 
9 nodes that are directly connected to Gandalf. This gives a degree of separation of 3.

## IntelliJ setup guide

As of 20th Sept. This is a guide to run this within intellij 

1. From https://adoptopenjdk.net/index.html download OpenJDK 11 (LTS) with the HotSpot VM
2. Enable this as the project SDK under File > Project Structure > Project Settings > Project > Project SDK
3. Create a new configuration as an `Application` , select Java 11 as the build, and `com.raphtory.examples.lotr.Runner` as the class, add the Environment Variables also


