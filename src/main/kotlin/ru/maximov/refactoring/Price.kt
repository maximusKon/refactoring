package ru.maximov.refactoring

abstract class Price {
    abstract fun getPriceCode() : Int

    abstract fun getCharge(daysRented: Int): Double
}