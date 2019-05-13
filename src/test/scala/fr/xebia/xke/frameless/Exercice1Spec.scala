package fr.xebia.xke.frameless

import org.scalatest._

class Exercice1Spec extends FlatSpec
  with Matchers
  with GivenWhenThen
  with SparkUtils
  with Data {

  import spark.implicits._

  behavior of "Exercice1"

  it should "select all players" in {
    Given("a dataset")
    val matchsDS = matchs.toDS()

    When("Selecting the players")
    val res = Exercice1.selectAllPlayers(matchsDS)

    Then("Voilà!")
    res should have size 30
    res.distinct should contain theSameElementsAs Seq("Olivier", "Charles", "Thomas", "Bastien", "Julien", "Joachim")
  }

  it should "select all players typed" in {
    Given("a dataset")
    val matchsDS = matchs.toDS()

    When("Selecting the players")
    val res = Exercice1.selectAllPlayersTyped(matchsDS)

    Then("Voilà!")
    res should have size 30
    res.distinct should contain theSameElementsAs Seq("Olivier", "Charles", "Thomas", "Bastien", "Julien", "Joachim")
  }
}
