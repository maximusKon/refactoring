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
            var thisAmount = 0.0
            val each = rentals.nextElement()

            //определить сумму для каждой строки
            thisAmount = amountFor(each)

            //добавить очки для активного арендатора
            frequentRenterPoints++
            //бонус за аренду новинки на два дня
            if((each.movie.priceCode == Movie.NEW_RELEASE) &&
                    each.daysRented > 1)
                frequentRenterPoints++

            //показать результаты для этой аренды
            result += "\t ${each.movie.title} \t $thisAmount \n"
            totalAmount += thisAmount
        }
        //добавить нижний колонтитул
        result += "Сумма задолженности составляет $totalAmount \n"
        result += "Вы заработали $frequentRenterPoints очков за активность"

        return result
    }

    private fun amountFor(aRental: Rental): Double {
        var result = 0.0
        when (aRental.movie.priceCode) {
            Movie.REGULAR -> {
                result += 2
                if (aRental.daysRented > 2)
                    result += (aRental.daysRented - 2) * 1.5
            }
            Movie.NEW_RELEASE -> result += aRental.daysRented * 3
            Movie.CHILDRENS -> {
                result += 1.5
                if (aRental.daysRented > 3)
                    result += (aRental.daysRented - 3) * 1.5
            }
        }
        return result
    }
}