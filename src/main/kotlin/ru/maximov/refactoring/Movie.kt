package ru.maximov.refactoring

data class Movie(val title:String, var priceCode:Int) {
    companion object {
        const val CHILDRENS = 2
        const val REGULAR = 0
        const val NEW_RELEASE = 1
    }

    fun getCharge(daysRented: Int): Double {
        var result = 0.0
        when (priceCode) {
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

    fun getFrequentRenterPoints(daysRented: Int): Int =
            if ((priceCode == Movie.NEW_RELEASE) && daysRented > 1)
                2
            else
                1
}