import sbt._

object Dependencies {
  lazy val framelessVersion = "0.8.0" // for Spark 2.4.0

  lazy val framelessDataset = "org.typelevel" %% "frameless-dataset" % framelessVersion
  lazy val framelessMl = "org.typelevel" %% "frameless-ml" % framelessVersion
  lazy val framelessCats = "org.typelevel" %% "frameless-cats" % framelessVersion
  lazy val sparkCore = "org.apache.spark" %% "spark-core" % "2.4.1"
  lazy val sparkSql = "org.apache.spark" %% "spark-sql" % "2.4.1"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
}
