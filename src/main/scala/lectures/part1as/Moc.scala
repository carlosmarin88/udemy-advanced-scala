package lectures.part1as

object Moc extends App {

  println("8544271682".takeRight(20))

  println(BigInt("4618330544045998658544271682".takeRight(20)))

  println(s"%0${20}d".format(BigInt("4618330544045998658544271682".takeRight(20))))
}
