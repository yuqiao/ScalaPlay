package com.yuqiao.playground.ProgrammingInScala

/**
 * Breif:  
 * User: rongqiao.yurq
 * Date: 13-8-25 下午1:42
 */
object Chapter9 {
  private def filesHere = (new java.io.File(".")).listFiles()
  def filesMatching(matcher: String =>Boolean) =
    for(file <- filesHere; if matcher(file.getName))
      yield file

  def fileEnding( query: String) =
    filesMatching( _.endsWith(query) )

  def fileContaining( query: String) =
    filesMatching( _.contains(query) )

}
