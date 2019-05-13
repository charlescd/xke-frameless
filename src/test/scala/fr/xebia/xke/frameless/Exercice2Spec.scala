package fr.xebia.xke.frameless

import fr.xebia.xke.frameless.Garou.DurationByPlayer
import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

class Exercice2Spec extends FlatSpec
  with Matchers
  with GivenWhenThen
  with SparkUtils
  with Data {

  import spark.implicits._

  behavior of "Exercice2"

  it should "maxDuration" in {
    Given("a dataset")
    val matchsDS = matchs.toDS()

    When("Selecting the max duration")
    val res = Exercice2.maxDuration(matchsDS)

    Then("Voilà!")
    res shouldBe DurationByPlayer("Bastien", 101L)
  }

  it should "maxDurationTyped" in {
    Given("a dataset")
    val matchsDS = matchs.toDS()

    When("Selecting the max duration")
    val res = Exercice2.maxDurationTyped(matchsDS)

    Then("Voilà!")
    res shouldBe DurationByPlayer("Bastien", 101L)
  }

}
