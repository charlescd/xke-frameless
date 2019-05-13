package fr.xebia.xke.frameless


object Garou {
  case class Match(player1: String, char1: String, player2: String, char2: String, score: String, duration: Long)

  case class Player(name: String, surname: String, tagline: Option[String])


  case class Players(player1: String, player2: String)

  case class DurationByPlayer(player: String, duration: Long)


  sealed abstract class Character

  case object Dong extends Character

  case object Gato extends Character

  case class MainChar(player: String, character: Character)
}