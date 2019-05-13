package fr.xebia.xke.frameless

import fr.xebia.xke.frameless.Garou.{Match, Player}

trait Data {

  val matchs: Seq[Match] = Seq(
    Match("Olivier", "Butt", "Bastien", "Gato", "2-1", 67000L),
    Match("Thomas", "Rock", "Olivier", "Gato", "1-2", 68000L),
    Match("Charles", "Dong", "Olivier", "Butt", "2-1", 77000L),
    Match("Julien", "Butt", "Olivier", "Butt", "2-1", 80000L),
    Match("Olivier", "Gato", "Joachim", "Hotaru", "2-0", 81000L),

    Match("Charles", "Dong", "Julien", "Butt", "0-2", 42000L),
    Match("Charles", "Kevin", "Joachim", "Hotaru", "2-0", 56000L),
    Match("Charles", "Kevin", "Bastien", "Gato", "2-1", 75000L),
    Match("Thomas", "Rock", "Charles", "Dong", "2-1", 75000L),

    Match("Julien", "Butt", "Joachim", "Hotaru", "2-0", 51000L),
    Match("Bastien", "Gato", "Julien", "Butt", "0-2", 40000L),
    Match("Julien", "Butt", "Thomas", "Rock", "2-1", 78000L),

    Match("Bastien", "Gato", "Thomas", "Rock", "1-2", 83000L),
    Match("Thomas", "Rock", "Joachim", "Hotaru", "2-0", 74000L),

    Match("Bastien", "Gato", "Joachim", "Hotaru", "1-2", 101000L),
  )

  val players: Seq[Player] = Seq(
    Player("Olivier", "Ghizzo", Some("Gato il est cheaté")),
    Player("Julien", "Smadja", None),
    Player("Thomas", "Simonnet", None),
    Player("Bastien", "Chares", Some("Frametrap !")),
    Player("Joachim", "Rousseau", Some("Je préfère être à droite !")),
  )
}