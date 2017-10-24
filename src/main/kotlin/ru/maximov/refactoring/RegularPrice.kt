package ru.maximov.refactoring

class RegularPrice : Price() {
    override fun getPriceCode(): Int = Movie.REGULAR
}