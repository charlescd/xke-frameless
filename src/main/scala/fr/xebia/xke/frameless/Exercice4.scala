package fr.xebia.xke.frameless

import fr.xebia.xke.frameless.Garou.{Match, Player}
import frameless.TypedDataset
import frameless.syntax._
import org.apache.spark.sql.Dataset

object Exercice4 {

  def joinTaglineTyped(matchs: Dataset[Match], players: Dataset[Player]): Seq[(Match, Option[Player])] = {

    ???
  }
}
