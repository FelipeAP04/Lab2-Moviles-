
fun calcularPromedio(numbers: List<Int>): Double {
    return numbers.reduce { acc, num -> acc + num }.toDouble() / numbers.size
}

fun filter(numbers: List<Int>): List<Int> {
    return numbers.filter { num -> num % 2 != 0 }
}

fun isPalindrome(cadena: String): Boolean {
    val reves = cadena.reversed()
    return cadena.equals(reves, ignoreCase = true)
}

fun saludo(names: List<String>): List<String> {
    return names.map { "¡Hola, $it!" }
}

fun operation(num1: Int, num2: Int, lamb: String): Int {
    return when (lamb) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num1 / num2
        else -> throw IllegalArgumentException("Operando no valido: $lamb. operandos validos: +, -, *, /")
    }
}

data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

var studentIdCounter = 1

fun personToStudent(person: Person): Student {
    return Student(person.name, person.age, person.gender, "STUDENT-$studentIdCounter")
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    println("El promedio es: ${calcularPromedio(numbers)}")
    println("Los numeros impares de esta lista son: ${filter(numbers)}")
    println("${isPalindrome("ana")}")
    println("${saludo(listOf("Alicia", "Juan", "María", "Pedro", "Sofía"))}")
    println("${operation(5, 5, "*")}")

    val people = listOf(
        Person("Juan", 20, "Masculino"),
        Person("María", 22, "Femenino"),
        Person("Pedro", 25, "Masculino")
    )

    val students = people.map {
        val student = personToStudent(it)
        studentIdCounter++
        student
    }


    students.forEach { student ->
        println("El Estudiante ${student.name} tiene ${student.age} años.")
    }
}