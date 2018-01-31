package myscala.basic

/**
  * Created by docker on 2017/5/24.
  */
class 提取器 {

}

object 提取器 {
  def main(args: Array[String]) {

    println("Apply 方法 : " + apply("Zara", "gmail.com"));
    println("Unapply 方法 : " + unapply("Zara@gmail.com").get);
    println("Unapply 方法 : " + (unapply("Zara Ali")).getOrElse("返回值为空"));

  }

  // 注入方法 (可选)无需使用 new 操作就可以创建对象
  def apply(user: String, domain: String) = {
    user + "@" + domain
  }

  // 提取方法（必选）接收对象
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) {
      var res = Some(parts(0), parts(1))
      res
    } else {
      None
    }
  }
}