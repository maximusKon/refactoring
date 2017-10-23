package ru.maximov.refactoring

import java.util.*

data class Customer(val name:String) {
    val rentals : Vector<Rental> = Vector()

    fun addRental(arg:Rental) = rentals.addElement(arg)

    fun statement() : String {
        var frequentRenterPoints = 0
        val rentals = this.rentals.elements()
        var result = "Учёт аренды для $name\n"
        while(rentals.hasMoreElements()){
            val each = rentals.nextElement()

            frequentRenterPoints += each.getFrequentRenterPoints()

            //показать результаты для этой аренды
            result += "\t ${each.movie.title} \t ${each.getCharge()} \n"
        }
        //добавить нижний колонтитул
        result += "Сумма задолженности составляет ${getTotalCharge()} \n"
        result += "Вы заработали $frequentRenterPoints очков за активность"

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