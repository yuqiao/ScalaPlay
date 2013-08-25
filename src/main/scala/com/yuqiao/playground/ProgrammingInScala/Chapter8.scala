package com.yuqiao.playground.ProgrammingInScala

import scala.io.Source

/**
 * Breif:  
 * User: rongqiao.yurq
 * Date: 13-8-24 上午9:39
 */
object Chapter8 {
  val increase = (x:Int) => x + 1
  val increaseB = (x:Int) => {
    println("We")
    println("Are")
    println("Here")
    x + 1
  }
  val someNumbers = List(-11,-10,-5,0, 5, 10)
  def sum(x:Int,y:Int,z:Int) = x + y + z

  def processFile(filename:String, width:Int) {
    val source = Source.fromFile(filename)
    for( line <- source.getLines())
      processLine(filename, line, width)
  }
  private def processLine(filename:String, line:String, width:Int){
    if(line.length > width)
      println( filename + ": " + line.trim )

  }

  def echo(args: String*) =
    for( arg <- args) println( arg)

  def main(args: Array[String]) {
    println("chapter8.")
    println( increase(8))
    println( increaseB(1000))
    someNumbers.foreach( (x:Int) => println(x) )
    println( someNumbers.filter( _ > 0))
    val a = sum _
    println( a(1,2,3))
    val b = sum(1, _: Int, 3)
    println( b(6))
    var more = 1
    val addMore = (x:Int) => x + more
    println( addMore(10))
    more = 9999
    println( addMore(10))
    var s = 0
    println( someNumbers.foreach( s += _ ) )
    println( "s:" + s)
    echo("hello", " ", "yuqiao")

  }
}
