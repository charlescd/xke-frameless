package fr.xebia.xke.frameless

import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

class Exercice4Spec extends FlatSpec
  with Matchers
  with GivenWhenThen
  with SparkUtils
  with Data {

  import spark.implicits._

  behavior of "Exercice4"

  it should "joinTaglineTyped" in {
    Given("a dataset")
    val matchsDS = matchs.toDS()
    val playersDS = players.toDS()

    When("Joining")
    val res = Exercice4.joinTaglineTyped(matchsDS, playersDS)

    Then("Voilà!")
    res.filter(_._2.isDefined) should have size 11
    res.filter(_._2.isEmpty) should have size 4
  }

}
