package exercises

import scala.util.{Failure, Try}

object Poc extends App {

  //val templateMessage: String = "hola %s"

  //val name = "carlos"

   //println(templateMessage.format(name))


 // val result = handleError()

  //println(s"El resultado es: ${result.isSuccess}")


  //val one_mb = 1024L * 1024L * 2

  //val one_mb_v2 = (1024L * 1024L) * 2

  //println(s"1 mb = ${one_mb} bt")

  //println(s"1 mb = ${one_mb_v2} bt")

  //IIBB_aditional_info
  val prop = "AR-E=FALSE"

  val propertyExpr = """(.+)=(.+)""".r

  val map: Map[String, String] = prop.split("\\|")
    .filter(prop => propertyExpr.findFirstIn(prop).isDefined).map { regex =>
    regex match {
      case propertyExpr(key, value) => key.toLowerCase -> value
    }
  }.toMap

  println(map)


   def handleError(): Try[Unit] = {

     for {
       _ <- Try(if(true) {
         println("lanzar excepcion")
         throw new Exception("propagar error")
       })
     } yield ()
   }
}
