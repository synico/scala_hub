
class Upper {
  def upper(strings: String*): Seq[String] = {
    strings.map((s:String) => s.toUpperCase)
  }
}

val up = new Upper
val rst = up.upper("Hello", "World!")
println(rst)