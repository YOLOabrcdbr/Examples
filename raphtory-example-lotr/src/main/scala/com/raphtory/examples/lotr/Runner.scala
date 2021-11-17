package com.raphtory.examples.lotr

import com.raphtory.RaphtoryGraph
import com.raphtory.algorithms.ConnectedComponents
import com.raphtory.examples.lotr.graphbuilders.LOTRGraphBuilder
import com.raphtory.examples.lotr.spouts.LOTRSpout
import com.raphtory.examples.lotr.analysis.LOTRSixDegreesAnalyser

import com.raphtory.serialisers.{DefaultSerialiser}


object Runner extends App{
        val source  = new LOTRSpout()
        val builder = new LOTRGraphBuilder()
        val rg = RaphtoryGraph[String](source,builder)
        rg.viewQuery(LOTRSixDegreesAnalyser(seperation = 3), serialiser = new DefaultSerialiser,timestamp = 5000)
        //rg.rangeQuery(new ConnectedComponents(Array()), serialiser = new DefaultSerialiser, start=1, end = 32674, increment=1000,windowBatch=List(10000, 1000,100))
        //rg.rangeQuery(ConnectedComponents(), serialiser = new DefaultSerialiser,start = 1,end = 32674,increment = 100,arguments)
        //rg.rangeQuery(ConnectedComponents(), serialiser = new DefaultSerialiser,start = 1,end = 32674,increment = 100,window=100,arguments)
        //rg.rangeQuery(ConnectedComponents(), serialiser = new DefaultSerialiser,start = 1,end = 32674,increment = 100,windowBatch=List(100,50,10),arguments)
        //rg.viewQuery(DegreeBasic(), serialiser = new DefaultSerialiser,timestamp = 10000,arguments)
        //rg.viewQuery(DegreeBasic(), serialiser = new DefaultSerialiser,timestamp = 10000,window=100,arguments)
}