package myscala.basic

;

import java.io._

class Yiibai1(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
}

//创建单例对象
object Test2a {
  def main(args: Array[String]) {
    val yiibai1 = new Yiibai1(10, 20)
    printYiibai

    def printYiibai {
      println("Yiibai x location : " + yiibai1.x);
      println("Yiibai y location : " + yiibai1.y);
    }
  }
}