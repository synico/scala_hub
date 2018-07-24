
val pf1: PartialFunction[Any, String] = {
  case s: String => "YES"
  case x: Int => "NO"
  case _ => "FK"
}
val pf2: PartialFunction[Any, String] = { case d: Double => "YES"}

val pf = pf1 orElse pf2

def tryPF(x: Any, f: PartialFunction[Any, String]): String =
  try { f(x).toString } catch { case _: MatchError => "ERROR!"}

def d(x: Any, f: PartialFunction[Any, String]) = f.isDefinedAt(x).toString

pf1(2.2)
pf2(1)