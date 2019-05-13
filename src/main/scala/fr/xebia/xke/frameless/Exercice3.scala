package fr.xebia.xke.frameless

import fr.xebia.xke.frameless.Garou.Match
import frameless.TypedDataset
import frameless.syntax._
import org.apache.spark.sql.Dataset


object Exercice3 {

  val winner: (String, String, String) => String = (player1, player2, score) => {
    val p1Score = score.split("-")(0).toInt
    if (p1Score == 2) player1 else player2
  }


  def selectWinner(matchs: Dataset[Match]): Seq[String] = {
    import org.apache.spark.sql.functions._

    val winnerUDF = udf(winner)

    matchs
      .withColumn("winner", winnerUDF(col("player"), col("player2"), col("score")))
      .select("winner")
      .distinct()
      .collect()
      .map(_.getAs[String]("winner"))
  }


  def selectWinnerTyped(matchs: Dataset[Match]): Seq[String] = {
    ???

  }
}
