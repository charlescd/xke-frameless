package fr.xebia.xke.frameless

import fr.xebia.xke.frameless.Garou.{DurationByPlayer, Match}
import frameless.TypedDataset
import frameless.functions.aggregate._
import frameless.syntax._
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.types.DataTypes

object Exercice2 {

  def maxDuration(matchs: Dataset[Match]): DurationByPlayer = {
    import org.apache.spark.sql.functions._

    val playersDataset =
      matchs
        .select("player1", "duration")
        .union(
          matchs
            .select("player2", "duration")
        )

    playersDataset
      .groupBy("player")
      .agg((max(col("duration")) / 1000L).cast(DataTypes.StringType).as("max"))
      .orderBy(col("max").desc)
      .collect()
      .map(row => DurationByPlayer(row.getAs[String]("player1"), row.getAs[Long]("max")))
      .head
  }

  def maxDurationTyped(matchs: Dataset[Match]): DurationByPlayer = {
    ???
  }

}
