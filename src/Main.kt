import java.util.*

fun main(args: Array<String>) {
    val game = Cities()
    var gameOver = false
//    print(game.cities)

    val cities = Cities()

    println("Welcome to Cities-game! Let's start")
    val scan = Scanner(System.`in`)
    game.initializeGame()

    while (!gameOver) {
//        gameOver = readLine()?.let { cities.processCity(it) }!!
        val now = scan.nextLine()
        gameOver = cities.processCity(now)
    }
    print("THat's all")
}