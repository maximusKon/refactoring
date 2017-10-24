package ru.maximov.refactoring

class NewReleasePrice : Price() {
    override fun getPriceCode(): Int = Movie.NEW_RELEASE

    override fun getCharge(daysRented: Int): Double = (daysRented * 3).toDouble()

    override fun getFrequentRenterPoints(daysRented: Int): Int =
            if(daysRented > 1) 2 else 1
}