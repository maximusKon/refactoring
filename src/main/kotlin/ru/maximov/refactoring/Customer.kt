package ru.maximov.refactoring

import java.util.*

data class Customer(val name:String) {
    val rentals : Vector<Rental> = Vector()

    fun addRental(arg:Rental) = rentals.addElement(arg)

    fun statement() : String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        val rentals = this.rentals.elements()
        var result = "Учёт аренды для $name\n"
        while(rentals.hasMoreElements()){
            val each = rentals.nextElement()

            //добавить очки для активного арендатора
            frequentRenterPoints++
            //бонус за аренду новинки на два дня
            if((each.movie.priceCode == Movie.NEW_RELEASE) &&
                    each.daysRented > 1)
                frequentRenterPoints++

            //показать результаты для этой аренды
            result += "\t ${each.movie.title} \t ${each.getCharge()} \n"
            totalAmount += each.getCharge()
        }
        //добавить нижний колонтитул
        result += "Сумма задолженности составляет $totalAmount \n"
        result += "Вы заработали $frequentRenterPoints очков за активность"

        return result
    }

}