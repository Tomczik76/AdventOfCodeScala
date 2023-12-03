package day1

import scala.io.Source

@main def main =
  println("part1: " + dope(numbers))
  println("part2: " + dope(numbers ++ words))

val words = Map(
  "one" -> "1",
  "two" -> "2", 
  "three" -> "3", 
  "four" -> "4", 
  "five" -> "5", 
  "six" -> "6", 
  "seven" -> "7", 
  "eight" -> "8", 
  "nine" -> "9")

val numbers = (1 to 9).map(_.toString).map(x => x -> x).toMap

def dope(tokens: Map[String, String]) =
  Source.fromResource("day1.txt")
    .getLines
    .map: line => 
      val (_, first) = 
        tokens.map:
          case (t, v) => line.indexOf(t) -> v
        .filter:
          case (i, _) => i > -1
        .min
    
      val (_, lastest) = 
        tokens.map:
          case (t, v) => line.lastIndexOf(t) -> v
        .filter:
          case (i, _) => i > -1
        .max

      (first + lastest).toInt
    .sum