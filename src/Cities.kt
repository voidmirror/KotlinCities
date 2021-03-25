import java.io.File

class Cities {
    val cities: MutableMap<Char, MutableList<String>> = mutableMapOf()
    val letters: MutableList<Char> = mutableListOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    val city: MutableList<MutableList<String>> = mutableListOf()
    var currentLetter = 'A'

    init {
//        var letter = 'A'
//        for (char i in letter..letter+26)
//        cities.put("A", var list: MutableList)
        parseCitiesFile()
    }

    fun parseCitiesFile() {
        var lines = File("src\\city.txt").readLines()
        for (let in letters) {
//            print(let)
            cities.put(let, mutableListOf())
        }
        for (line in lines) {
//            print(line)
//            print(line[0])
            cities[line[0]]?.add(line)
        }
    }

    fun initializeGame() {
//        print(cities.entries)
        println("My first city is ${cities['A']?.get(0)}, you next:")
//        currentLetter = cities['A']?.get((0..(cities['A']?.size)!!).random())?.get(0)!!
        currentLetter = cities['A']?.get(0)?.get(0)!!
        cities['A']?.remove(cities['A']?.get(0))
    }

    fun processCity(city: String): Boolean {
        return if (cities[city[0]]?.contains(city)!!) {
            println("Yes, thats  good!")
            cities[city[0]]?.remove(city)
            if (cities[city.last()]?.get(0) != null) {
                print("Your next city is ${cities[city.last()]?.get(0)}")
                currentLetter = cities[city.last()]?.get(0)?.get(0)!!
                true
            } else {
                print("You Won! Get your prize and see you next time!")
                false
            }
        } else {
            println("I don't know this city =( Try again, please")
            false
        }
    }
}