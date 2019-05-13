package fr.xebia.xke.frameless

import java.time.OffsetDateTime

import fr.xebia.xke.frameless.Garou._
import frameless.syntax._
import frameless.{Injection, TypedDataset}
import org.apache.spark.sql.SparkSession

case class DateRange(s: java.time.OffsetDateTime, e: java.time.OffsetDateTime)

object Exercice5 extends App {

  implicit val spark: SparkSession = SparkSession
    .builder()
    .appName("Frameless XKE")
    .master("local[*]")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  encoders()
  encodersTyped()
  encodersTyped2()


  def encoders() = {
//    val ds = spark.createDataset(Seq(DateRange(OffsetDateTime.now(), OffsetDateTime.now())))
//    ds.show()
  }

  def encodersTyped() = {
    //    val ds = TypedDataset.create(Seq(DateRange(OffsetDateTime.now(), OffsetDateTime.now())))
    //    ds.show().run()
  }

  implicit lazy val charToStringInjection: Injection[Character, String] = new Injection[Character, String] {
    override def apply(a: Character): String = a match {
      case Dong => "Dong"
      case Gato => "Gato"
    }

    override def invert(b: String): Character = b match {
      case "Dong" => Dong
      case "Gato" => Gato
    }
  }

  def encodersTyped2() = {
    val ds = TypedDataset.create(Seq(MainChar("Charles", Dong)))
    ds.show().run()
  }
}
