package fr.xebia.xke.frameless

import org.apache.spark.sql.SparkSession

trait SparkUtils {

  val spark: SparkSession = SparkSession
    .builder()
    .appName("Frameless XKE")
    .master("local[*]")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

}
