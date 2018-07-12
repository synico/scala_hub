
class Upper {
  def upper(strings: String*): Seq[String] = {
    strings.map((s:String) => s.toUpperCase)
  }

  // omit input parameters
  def upper1: Seq[String] = {
    Seq("1", "2")
  }

  // omit define return type
  def upper2 = {
    List("3", "4", "5")
  }

  def upper3 =  List("6", "7", 8)
}

val up = new Upper
val rst = up.upper("Hello", "World!")
println(rst)

println(up.upper1)

println(up.upper2)

println(up.upper3)

object Upper {
  def upper4(strings: String*) = strings.map(_.toUpperCase)

  def upper5 =  List("6", "7", 8)
}

Upper.upper4("a", "b")

Upper.upper5