package com.raphtory.examples.gab;

import com.raphtory.examples.gab.graphbuilders.GabUserGraphBuilder
import com.raphtory.core.build.server.RaphtoryGraph
import com.raphtory.algorithms.{ConnectedComponents}//DegreeBasic}
import com.raphtory.spouts.FileSpout

object Runner extends App{
        val source    = new FileSpout("src/main/scala/com/raphtory/examples/gab/data/","gabNetwork500.csv")
        val builder   = new GabUserGraphBuilder()
        val rg        = RaphtoryGraph[String](source,builder)
        Thread.sleep(60000)
        rg.rangeQuery(ConnectedComponents(path="/tmp/connectedComponents"), start = 1470797917000L, end = 1476113868000L, increment = 86400000L, windows = List(3600000L, 86400000L, 604800000L, 2592000000L, 31536000000L))
        //rg.rangeQuery(ConnectedComponents(),start = 1,end = 32674,increment = 100,window=100,arguments)
        //rg.rangeQuery(ConnectedComponents(),start = 1,end = 32674,increment = 100,windowBatch=Array(3600,36000,360000),arguments)
        //rg.viewQuery(DegreeBasic(),timestamp = 10000,arguments)
        //rg.viewQuery(DegreeBasic(),timestamp = 10000,window=100,arguments)
        //rg.viewQuery(DegreeBasic(),timestamp = 10000,windowBatch=Array(100,50,10),arguments)
        }
