package fr.xebia.xke.frameless

import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

class Exercice3Spec extends FlatSpec
  with Matchers
  with GivenWhenThen
  with SparkUtils
  with Data {

  import spark.implicits._

  behavior of "Exercice3"

  it should "selectWinner" in {
    Given("a dataset")
    val matchsDS = matchs.toDS()

    When("Selecting the winners")
    val res = Exercice3.selectWinner(matchsDS)

    Then("Voilà!")
    res should contain theSameElementsAs Seq(
      "Charles", "Julien", "Olivier", "Joachim", "Thomas"
    )
  }

  it should "selectWinnerTyped" in {
    Given("a dataset")
    val matchsDS = matchs.toDS()

    When("Selecting the winners")
    val res = Exercice3.selectWinnerTyped(matchsDS)

    Then("Voilà!")
    res should contain theSameElementsAs Seq(
      "Charles", "Julien", "Olivier", "Joachim", "Thomas"
    )
  }

}
