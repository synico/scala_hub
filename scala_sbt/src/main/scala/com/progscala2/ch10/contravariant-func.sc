
val list = List(1, 2, 3, 4)
val list1 = list map (i => i +3)

val func1: Int => Int = new Function1[Int, Int] {
  def apply(i: Int): Int = i + 3
}

val list2 = list map (func1.apply)
val list3 = list map (func1)


class CSuper                  { def msuper() = println("CSuper") }
class C     extends CSuper    { def m() = println("C") }
class CSub  extends  C        { def msub() = println("CSub") }

var f: C => C = (c: C)        => new C
    f         = (c: CSuper)   => new CSub
    f         = (c: CSuper)   => new C
    f         = (c: C)        => new CSub
//    f         = (c: CSub)     => new CSuper //compile error

val f1: C => C = new Function1[C, C] {
  override def apply(v1: C): C = new C
}

val f2: C => C = new Function1[CSuper, CSub] {
  override def apply(v1: CSuper) = new CSub
}

val f3: C => C = new Function1[CSuper, C] {
  override def apply(v1: CSuper) = new C
}

val f4: C => C = new Function1[C, CSub] {
  override def apply(v1: C) = new CSub
}

val f5: C => C = new Function1[C, C] {
  override def apply(v1: C) = new CSub
}

f1(new C).m()
f2(new CSub).msuper()
