package ru.maximov.refactoring

import java.util.*

data class Customer(val name:String) {
    val rentals : Vector<Rental> = Vector()

    fun addRental(arg:Rental) = rentals.addElement(arg)

    fun statement() : String {
        val rentals = this.rentals.elements()
        var result = "Учёт аренды для $name\n"
        while(rentals.hasMoreElements()){
            val each = rentals.nextElement()
            //показать результаты для этой аренды
            result += "\t ${each.movie.title} \t ${each.getCharge()} \n"
        }
        //добавить нижний колонтитул
        result += "Сумма задолженности составляет ${getTotalCharge()} \n"
        result += "Вы заработали ${getTotalFrequentRenterPoints()} очков за активность"

        return result
    }

    fun htmlStatement(): String {
        val rentals = this.rentals.elements()
        var result = "<H1>Операции аренды для <EM>$name</EM></H1><P>\n"
        while(rentals.hasMoreElements()){
            val each = rentals.nextElement()
            //показать результаты для этой аренды
            result += "${each.movie.title}: ${each.getCharge()}<BR>\n"
        }
        //добавить нижний колонтитул
        result += "<P>Ваша задолженность составляет <EM>${getTotalCharge()}</EM><P>"
        result += "На этой аренде вы заработали <EM>${getTotalFrequentRenterPoints()}</EM> очков за активность<P>"

        return result
    }

    private fun getTotalFrequentRenterPoints() : Int{
        var result = 0
        val rentals = this.rentals.elements()
        while(rentals.hasMoreElements()) {
            val each = rentals.nextElement()
            result += each.getFrequentRenterPoints()
        }
        return result
    }

    private fun getTotalCharge(): Double {
        var result = 0.0
        val rentals = this.rentals.elements()
        while(rentals.hasMoreElements()) {
            val each = rentals.nextElement()
            result += each.getCharge()
        }
        return result
    }
}