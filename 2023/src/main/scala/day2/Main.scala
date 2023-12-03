package day2

import scala.io.Source

@main def main =
  println("part1: " + part1)
  println("part1: " + part2)

def colorMaximumus: Iterator[Map[String, Int]] =
  Source.fromResource("day2.txt")
    .getLines
    .map: line => 
      line.split(':')(1)
        .split(';')
        .flatMap(_.split(','))
        .groupBy:
          case s if s.contains("blue") => "blue"
          case s if s.contains("red") => "red"
          case s => "green"
        .map:
          case(c, l) => c -> l.map(_.stripSuffix(c).trim.toInt).max

def part1 =
  colorMaximumus
    .zipWithIndex
    .filter: 
      case (map, index) =>
        map("red") <= 12 && map("green") <= 13 && map("blue") <= 14
    .map(_._2 + 1)
    .sum
        

def part2 =
  colorMaximumus
    .map: map =>
      map("red") * map("green") * map("blue")
    .sum
        
        

    