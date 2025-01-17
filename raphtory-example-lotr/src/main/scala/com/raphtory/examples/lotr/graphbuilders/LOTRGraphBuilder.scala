package com.raphtory.examples.lotr.graphbuilders

import com.raphtory.core.components.graphbuilder.GraphBuilder
import com.raphtory.core.implementations.generic.messaging._
import com.raphtory.core.model.graph.{ImmutableProperty, Properties, Type}

class LOTRGraphBuilder extends GraphBuilder[String]{

  override def parseTuple(tuple: String) = {
    val fileLine   = tuple.split(",").map(_.trim)
    val sourceNode = fileLine(0)
    val srcID      = assignID(sourceNode)
    val targetNode = fileLine(1)
    val tarID      = assignID(targetNode)
    val timeStamp  = fileLine(2).toLong

    addVertex(timeStamp, srcID, Properties(ImmutableProperty("name",sourceNode)), Type("Character"))
    addVertex(timeStamp, tarID, Properties(ImmutableProperty("name",targetNode)), Type("Character"))
    addEdge(timeStamp, srcID, tarID, Type("Character Co-occurence"))
  }

}
