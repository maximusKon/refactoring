package ru.maximov.refactoring

abstract class Price {
    abstract fun getPriceCode() : Int

    abstract fun getCharge(daysRented: Int): Double

    open fun getFrequentRenterPoints(daysRented: Int): Int = 1
}