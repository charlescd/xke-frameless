package fr.xebia.xke.frameless

import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

class ExampleSpec extends FlatSpec
  with Matchers
  with GivenWhenThen
  with SparkUtils
  with Data {

  import spark.implicits._

  behavior of "Example"

  it should "selectScore" in {
    Given("a dataset")
    val matchsDS = matchs.toDS()

    When("Selecting the score")
    val scores = Example.selectScore(matchsDS)

    Then("It should return scores")
    scores should contain theSameElementsInOrderAs Seq(
      "2-1",
      "1-2",
      "2-1",
      "2-1",
      "2-0",
      "0-2",
      "2-0",
      "2-1",
      "2-1",
      "2-0",
      "0-2",
      "2-1",
      "1-2",
      "2-0",
      "1-2"
    )
  }

  it should "selectScoreTyped" in {
    Given("a dataset")
    val matchsDS = matchs.toDS()

    When("Selecting the score")
    val scores = Example.selectScoreTyped(matchsDS)

    Then("It should return scores")
    scores should contain theSameElementsInOrderAs Seq(
      "2-1",
      "1-2",
      "2-1",
      "2-1",
      "2-0",
      "0-2",
      "2-0",
      "2-1",
      "2-1",
      "2-0",
      "0-2",
      "2-1",
      "1-2",
      "2-0",
      "1-2"
    )
  }

}
