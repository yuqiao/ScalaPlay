package com.yuqiao.playground.ProgrammingInScala

import java.io.{IOException, FileReader, FileNotFoundException, File}

/**
 * Breif:  
 * User: rongqiao.yurq
 * Date: 13-8-21 下午9:00
 */
object Chapter7 {
  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  def grep(fileList: Array[File], pattern: String) =
    for{
      file <- fileList
      if file.getName.endsWith(".scala")
      line <- fileLines( file )
      trimed = line.trim
      if trimed.matches(pattern)
    } println(file + ": " + trimed)

  def forEx {
    val filesHere = (new java.io.File("./src/main/scala/com/yuqiao/playground")).listFiles
    for( file <- filesHere if file.getName.endsWith(".scala"))
      println( file )

    grep(filesHere, ".*yuqiao.*")

    for( i <- 1 until 8 if i % 2 == 0)
      println( i )
  }

  def exceptionEx = {
    try{
      val f = new FileReader("input.txt")
    }catch {
      case ex: FileNotFoundException => println("can not find the file")
      case ex: IOException => print("IOException")
    }
  }

  def matchEx(name:String) = {
    name match {
      case "salt" => println("peppper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _ => println("huh?")
    }
  }
  def makeRowSeq(row: Int) =
    for ( col <- 1 to 10 ) yield {
      val prod = (row * col).toString
      val padding = " " * ( 4 - prod.length)
      padding + prod
    }

  def makeRow(row: Int) = makeRowSeq(row).mkString

  def multiTable() = {
    val tableSeq =
      for(row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
  }

  def yieldEx  = {
    for( i <- 1 until 8 if i % 2 == 0) yield {
      i * i +1
    }
  }
  def main(args: Array[String]) {
    println("chapter7")
    //forEx
    println( yieldEx )
    exceptionEx
    matchEx("salt")
    matchEx("hello")
    println( multiTable() )
  }
}
