package com.raphtory.examples.lotr.analysis

import com.raphtory.core.model.algorithm.{GraphAlgorithm, GraphPerspective, Row}

class DegreesSeperation(name: String = "Gandalf", fileOutput:String="/tmp/LOTRSixDegreesAnalyser") extends GraphAlgorithm {

  final val SEPARATION = "SEPARATION"

  override def algorithm(graph: GraphPerspective): Unit = {
    graph
      .step({
        vertex =>
          if (vertex.getPropertyOrElse("name", "") == name) {
            vertex.messageAllNeighbours(0)
            vertex.setState(SEPARATION, 0)
          } else{
            vertex.setState(SEPARATION, -1)
          }
      })
      .iterate(
        {
        vertex =>
          val sep_state = vertex.messageQueue[Int].max +1
          val current_sep = vertex.getStateOrElse[Int](SEPARATION, -1)
          if (current_sep == -1 & sep_state > current_sep) {
            vertex.setState(SEPARATION, sep_state)
            vertex.messageAllNeighbours(sep_state)
          }
        }, iterations = 100, executeMessagedOnly = true)
      .select(vertex => Row(vertex.getPropertyOrElse("name", "unknown"), vertex.getStateOrElse[Int](SEPARATION, -1)))
      //.filter(row=> row.getInt(1) > -1)
      .writeTo(fileOutput)
  }
}


object DegreesSeperation{
  def apply(name: String = "Gandalf", path:String="/tmp/DegreesSeperation") = new DegreesAnalyser(name, path)
}
