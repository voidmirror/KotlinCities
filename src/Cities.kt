import java.io.File

class Cities {
    val cities: MutableMap<Char, MutableList<String>> = mutableMapOf()
    val letters: MutableList<Char> = mutableListOf('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'К', 'И', 'Й', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Щ', 'Ш', 'Э', 'Ю', 'Я')
    val city: MutableList<MutableList<String>> = mutableListOf()
    var currentLetter = 'А'

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
        println("My first city is ${cities['А']?.get(0)}, you next:")
//        currentLetter = cities['A']?.get((0..(cities['A']?.size)!!).random())?.get(0)!!
        currentLetter = cities['А']?.get(0)?.get(0)!!
        cities['А']?.remove(cities['А']?.get(0))
    }

    fun processCity(city: String): Boolean {
        var cityCopy = city
        return if (cities[cityCopy[0]]?.contains(cityCopy)!!) {
            println("Yes, thats  good!")
            cities[cityCopy[0]]?.remove(cityCopy)
            if ((cityCopy.last() == 'ы') || (cityCopy.last() == 'ь') || (cityCopy.last() == 'ъ')) {
                cityCopy = "${cityCopy}${cityCopy[cityCopy.length - 2]}"
            }
            if (cities[cityCopy.last().toUpperCase()]?.get(0) != null) {
                println("Your next city is ${cities[cityCopy.last().toUpperCase()]?.get(0)}")
                currentLetter = cities[cityCopy.last().toUpperCase()]?.get(0)?.get(0)!!

                println("My next city is ${cities[currentLetter]?.get(0)}, you next:")

//                if ((currentLetter == 'ы') || (currentLetter == 'ь') || (currentLetter == 'ъ')) {
//                    currentLetter = cities[cityCopy.last().toUpperCase()]?.get(0)?.get(0)!!
//                }
                false
            } else {
                print("You Won! Get your prize and see you next time!")
                true
            }
        } else {
            println("I don't know this city =( Try again, please")
            false
        }
    }
}