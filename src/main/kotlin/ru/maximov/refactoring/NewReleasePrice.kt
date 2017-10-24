package ru.maximov.refactoring

class NewReleasePrice : Price() {
    override fun getPriceCode(): Int = Movie.NEW_RELEASE

    override fun getCharge(daysRented: Int): Double = (daysRented * 3).toDouble()
}