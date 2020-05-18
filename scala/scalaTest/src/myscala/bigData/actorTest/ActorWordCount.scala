package myscala.bigData.actorTest


import scala.actors.{Actor, Future}
import scala.collection.mutable.{HashSet, ListBuffer}
import scala.io.Source
/**
  * Created by root on 2016/5/11.
  */
class Task extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case SubmitTask(filename) => {
          //局部统计, 结果是Map[String, Int]                                                 toList将迭代器转换，才嫩用groupBy
          val result = Source.fromFile(filename).getLines().flatMap(_.split(" ")).map((_, 1)).toList.groupBy(_._1).mapValues(_.size)
          sender ! ResultTask(result) //发送ResultTask, 用它来包装result  老师处理完结果回给学生 多例，不new也是新对象
        }
        case StopTask => {
          exit()
        }
      }
    }
  }
}

case class SubmitTask(filename: String)
case class ResultTask(reslut : Map[String, Int])
case object StopTask //相当于只是一个信号

object ActorWordCount {

  def main(args: Array[String]) {
    val replySet = new HashSet[Future[Any]]()
    val resultList = new ListBuffer[ResultTask]()

    val files = Array[String]("words.log", "words.txt")
    for (f <- files) {
      val actor = new Task //有文件就开一个vector
      val reply = actor.start() !! SubmitTask(f)  //启动, 并发送消息,返回Future
      replySet += reply //把这些Future放到集合中
    }

    while(replySet.size > 0) {
      val toCompute = replySet.filter(_.isSet)  //取出有效的结果, 待处理的数据   isSet判断有没有结果
      for(f <- toCompute) {
        val result = f().asInstanceOf[ResultTask] //获取实例, 注意f后要加(), 调用apply(), 否则会报转换异常
        resultList += result
        replySet -= f //把计算完的任务干掉

      }
      Thread.sleep(100)
    }

    //汇总的功能
    //List((hello, 5), (tom,3), (helllo, 2), (jerry, 2))
    val fr = resultList.flatMap(_.reslut).groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))
    println(fr.toList)
//    List((,76), (李四,4), (赵四,4), (舞王,2), (动力汽车,2), (王五,2), (混合,2), (费玉清,2), (污王,2), (死神,2), (张三,4)) 76是统计的空格
    System.exit(0)
  }
}