package fr.xebia.xke.frameless

import fr.xebia.xke.frameless.Garou.{Match, Players}
import frameless.TypedDataset
import frameless.syntax._
import org.apache.spark.sql.Dataset

object Exercice1 {

  def selectAllPlayers(matchs: Dataset[Match]): Seq[String] = {
    val playersDataset = matchs.select("player1").union(matchs.select("player"))

    playersDataset.collect().toSeq.map(_.getString(0))
  }

  def selectAllPlayersTyped(matchs: Dataset[Match]): Seq[String] = {
    ???
  }

}
