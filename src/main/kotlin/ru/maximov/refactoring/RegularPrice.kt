package ru.maximov.refactoring

class RegularPrice : Price() {
    override fun getPriceCode(): Int = Movie.REGULAR

    override fun getCharge(daysRented: Int): Double{
        var result = 2.0
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5
        return result
    }
}