package fr.xebia.xke.frameless

import fr.xebia.xke.frameless.Garou.{Match, Players}
import frameless.TypedDataset
import frameless.syntax._
import org.apache.spark.sql.Dataset

object Exercice1 {

  def selectAllPlayers(matchs: Dataset[Match]): Seq[String] = {
    val playersDataset = matchs.select("player1").union(matchs.select("player2"))

    playersDataset.collect().toSeq.map(_.getString(0))
  }

  def selectAllPlayersTyped(matchs: Dataset[Match]): Seq[String] = {
    val typedMatchs = TypedDataset.create(matchs)
    val players = typedMatchs.project[Players]

    players
      .select(players('player1))
      .union(players.select(players('player2)))
      .collect()
      .run()
  }

}
