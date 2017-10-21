package ru.maximov.refactoring

import java.util.*

class Customer(private val name:String) {
    private val rentals : Vector<Rental> = Vector()

    fun addRental(arg:Rental) = rentals::addElement

    fun statement() : String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        val rentals = this.rentals.elements()
        var result = "Учёт аренды для $name\n"
        while(rentals.hasMoreElements()){
            var thisAmount = 0.0
            val each = rentals.nextElement()

            //определить сумму для каждой строки
            when (each.movie.priceCode) {
                Movie.REGULAR -> {
                    thisAmount += 2
                    if(each.daysRented > 2)
                        thisAmount += (each.daysRented - 2) * 1.5
                }
                Movie.NEW_RELEASE -> thisAmount+=each.daysRented * 3
                Movie.CHILDRENS -> {
                    thisAmount += 1.5
                    if(each.daysRented > 3)
                        thisAmount += (each.daysRented - 3) * 1.5
                }
            }

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
}