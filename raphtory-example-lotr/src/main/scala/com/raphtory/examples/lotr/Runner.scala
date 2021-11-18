package com.raphtory.examples.lotr

import com.raphtory.algorithms.{GraphState, TriangleCount}
import com.raphtory.core.build.server.RaphtoryGraph
import com.raphtory.spouts.FileSpout
import com.raphtory.examples.lotr.graphbuilders.LOTRGraphBuilder
import com.raphtory.examples.lotr.analysis.DegreesSeperation

object Runner extends App{
        val source  = new FileSpout("src/main/scala/com/raphtory/examples/lotr/data/","lotr.csv")
        val builder = new LOTRGraphBuilder()
        val rg = RaphtoryGraph[String](source,builder)

        rg.pointQuery(DegreesSeperation(name = "Gandalf"),32670)
}
        //rg.rangeQuery(new ConnectedComponents(Array()), serialiser = new DefaultSerialiser, start=1, end = 32674, increment=1000,windowBatch=List(10000, 1000,100))
        //rg.rangeQuery(ConnectedComponents(), serialiser = new DefaultSerialiser,start = 1,end = 32674,increment = 100,arguments)
        //rg.rangeQuery(ConnectedComponents(), serialiser = new DefaultSerialiser,start = 1,end = 32674,increment = 100,window=100,arguments)
        //rg.rangeQuery(ConnectedComponents(), serialiser = new DefaultSerialiser,start = 1,end = 32674,increment = 100,windowBatch=List(100,50,10),arguments)
        //rg.viewQuery(DegreeBasic(), serialiser = new DefaultSerialiser,timestamp = 10000,arguments)
        //rg.viewQuery(DegreeBasic(), serialiser = new DefaultSerialiser,timestamp = 10000,window=100,arguments)
