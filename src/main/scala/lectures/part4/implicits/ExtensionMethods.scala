package lectures.part4.implicits

class ExtensionMethods extends  App {

  case class Person(name: String) {
    def greet(): String = s"Hi, I'm $name, how can I help?"
  }

  extension (string: String) { // extension method
    def greetASPerson(): String = Person(string).greet()
  }

  val danielsGreeting = "Daniel".greetASPerson()

  // extension methods <=> implicit classes

  object Scala2ExtensionMethods {

    implicit class RichInt(val value: Int) {
      def isEven: Boolean = value % 2 == 0

      def sqrt: Double = Math.sqrt(value)

      def times(function: () => Unit): Unit = {
        def timeAux(n: Int): Unit =
          if (n <= 0) ()
          else {
            function()
            timeAux(n - 1)
          }

        timeAux(value)
      }
    }
    val is3Even = 3.isEven // new RichInt(3).isEven
  }

  extension (value: Int) {
    // define all methods
    def isEven: Boolean = value % 2 == 0

    def sqrt: Double = Math.sqrt(value)

    def times(function: () => Unit): Unit = {
      def timeAux(n: Int): Unit =
        if (n <= 0) ()
        else {
          function()
          timeAux(n - 1)
        }

      timeAux(value)
    }
  }

  // generic extensions
  extension [A](list: List[A]) {
    def ends: (A,A) = (list.head, list.last)
    def extremes(using ordering: Ordering[A]): (A, A) = list.sorted.ends // <-- can call an extension method here
  }

}
