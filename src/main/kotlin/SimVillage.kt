import kotlin.random.Random
import kotlin.random.nextInt
fun main(args: Array<String>) {

    //Write an anonymous function as an argument
    val numLetters = "Mississippi".count({ letter ->
        letter == 's'
    })
    print(numLetters)

    //************************************
    //*************************************************************

    //Inside the parentheses of printlin function
    println(
        {
        val curruntYear=2018
        "welcomw to SimVillage, Mayor1(copyright $curruntYear)"
    }() // we use () to call anonymous function to execute
    )

    //**************************
    //*************************************************************

    //declare var type of function then assigned it by anonymous function
    val  greetingFunction:()->String= {
        val curruntYear=2018
        "Welcome to SimVillage, Mayor1(copyrightb$curruntYear)" // does not require the return keyword, automatically return the last line
    }
    println(greetingFunction())
}
//**********************************
//*************************************************************

//multiple arguments
    val greetingFunction: (String, Int) -> String = { playerName,numBuildings -> //declaring parameters type in() then names after opining "{}" then after that ->
        val currentYear = 2018
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction("Guyal",, 2)) // here we pass parameter to anonymous (string parameter)
//********************************************************
//*************************************************************

//The it keyword
val greetingFunction: (String) -> String = {// Delete the parameter name and arrow
    val currentYear = 2018
    "Welcome to SimVillage, $it! (copyright $currentYear)"//use the "it" keyword instead parameter name
}
println(greetingFunction("Guyal"))

//**************************************
//*************************************************************

//Type Inference
val greetingFunction = { playerName: String, numBuildings: Int ->//Type inference(no need to declare return type)also we e including types for each parameter when we're declaring them in function/
    val currentYear = 2018
    println("Adding $numBuildings houses")
    "Welcome to SimVillage, $playerName! (copyright $currentYear)"
}
println(greetingFunction("Guyal", 2))
        //*********************************************************
//*************************************************************
//Function That Accepts a Function
        val greetingFunction = { playerName: String, numBuildings: Int ->//accept 2 parameters, 1st type of string 2nd type of function
            val currentYear = 2018
            println("Adding $numBuildings houses")
            "Welcome to SimVillage, $playerName! (copyright $currentYear)"
        }
runSimulation("Guyal", greetingFunction)// call function by pass 2 prammeter 1st is string 2nd is lambda
}
// Regular Function
fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = Random.nextInt(1..3)
    println(greetingFunction(playerName, numBuildings))//call lambda by pass parameters as what it accepts
}
//*************************************************************
//***********************************************

//Trailing lambda syntax
{
runSimulation("Guyal") { playerName, numBuildings ->/*here we call Function by pass 2 prameters 1st is string
and 2nd  directly passing lambda expression(no need to assigning the lambda to a variable) +it must be the lambda is the last parameter+*/
    val currentYear = 2018
    println("Adding $numBuildings houses")
    "Welcome to SimVillage, $playerName! (copyright $currentYear)"
}
    //***********************************************
//***********************************************

//Function References
{
    //here we call function by pass 3parameters, 1st string,2nd function reference,3rd lambda expression
    runSimulation("Guyal", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2018
        kotlin.io.println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}
    inline fun runSimulation(
        playerName: String,
        costPrinter: (Int) -> Unit,
        greetingFunction: (String, Int) -> String
    ) {
        val numBuildings = Random.nextInt(1..3)
        costPrinter(numBuildings)
        println(greetingFunction(playerName, numBuildings))
    }
    fun printConstructionCost(numBuildings: Int) {
        val cost = 500
        println("construction cost: ${cost * numBuildings}")
    }

//***********************************************
//***********************************************

//Function Type as Return Type
{
    runSimulation()
{
    fun runSimulation() {
        val greetingFunction = configureGreetingFunction()// lambda assigned by function
        println(greetingFunction("Reem")) //pass string to lambda who accept string and return string(then it will pass string to configureGreetingFunction fun)
    }
    fun configureGreetingFunction(): (String) -> String { //return type is function type(it will return lambda result)
        val structureType = "hospitals"
        var numBuildings = 5
        return { playerName: String -> //here is lambda expiration
            val currentYear = 2018
            numBuildings += 1
            println("Adding $numBuildings $structureType")
            "Welcome to SimVillage, $playerName! (copyright $currentYear)"
        }
    }

