package ru.maximov.refactoring

data class Rental(val movie: Movie, private val daysRented: Int){

    fun getCharge(): Double {
        var result = 0.0
        when (movie.priceCode) {
            Movie.REGULAR -> {
                result += 2
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5
            }
            Movie.NEW_RELEASE -> result += daysRented * 3
            Movie.CHILDRENS -> {
                result += 1.5
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5
            }
        }
        return result
    }

    fun getFrequentRenterPoints(): Int =
        if ((movie.priceCode == Movie.NEW_RELEASE) && daysRented > 1)
            2
        else
            1

}