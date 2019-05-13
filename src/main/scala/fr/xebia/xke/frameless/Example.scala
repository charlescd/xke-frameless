package fr.xebia.xke.frameless

import fr.xebia.xke.frameless.Garou.Match
import frameless.TypedDataset
import frameless.syntax._
import org.apache.spark.sql.Dataset

object Example {

  def selectScore(matchs: Dataset[Match]): Seq[String] = {
    matchs.select("core").collect().map(_.getString(0))
  }

  def selectScoreTyped(matchs: Dataset[Match]): Seq[String] = {
    ???
  }
}
