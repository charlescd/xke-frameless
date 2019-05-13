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
      .groupBy("player1")
      .agg((max(col("duration")) / 1000L).cast(DataTypes.LongType).as("max"))
      .orderBy(col("max").desc)
      .collect()
      .map(row => DurationByPlayer(row.getAs[String]("player1"), row.getAs[Long]("max")))
      .head
  }

  def maxDurationTyped(matchs: Dataset[Match]): DurationByPlayer = {
    val typedMatchs = TypedDataset.create(matchs)

    val players1 = typedMatchs.select(typedMatchs('player1), typedMatchs('duration)).as[DurationByPlayer]
    val players2 = typedMatchs.select(typedMatchs('player2), typedMatchs('duration)).as[DurationByPlayer]

    val players = players1.union(players2)

    val durations = players
      .groupBy(players('player))
      .agg((max(players('duration)) / 1000L).cast[Long])
      .as[DurationByPlayer]

    durations
      .orderBy(durations('duration).desc)
      .collect()
      .run()
      .head
  }

}
