
val pf1: PartialFunction[Any, String] = { case s: String => "YES"}
val pf2 = { case d: Double => "YES"}

val pf = pf1 orElse pf2

def tryPF(x: Any, f: PartialFunction[Any, String]): String =
  try { f(x).toString } catch { case _: MatchError => "ERROR!"}

def d(x: Any, f: PartialFunction[Any, String]) = f.isDefinedAt(x).toString