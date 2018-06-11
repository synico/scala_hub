val stateCapitals = Map(
  "Alabama" -> "Montgomery",
  "Alaska" -> "Juneau",
  "Wyoming" -> "Cheyenne"
)

println("Get the capitals wrapped in Options:")
println("Alabama: " + stateCapitals.get("Alabama"))
println("Wyoming: " + stateCapitals.get("Wyoming"))
println("Unknown: " + stateCapitals.get("Unknown"))

println("Get the capitals themselves out of the Options:")
println("Alabama: " + stateCapitals.get("Alabama").get)
println("Wyoming: " + stateCapitals.get("Wyoming").getOrElse("Oops!"))
println("Unknown: " + stateCapitals.get("Unknown").getOrElse("Oops2!"))

def stuffWithBigInteger() = {

  import java.math.BigInteger.{
    ONE => _,
    TEN,
    ZERO => JAVAZERO
  }

  println("TEN: " + TEN)
  println("ZERO: " + JAVAZERO)
}

stuffWithBigInteger()