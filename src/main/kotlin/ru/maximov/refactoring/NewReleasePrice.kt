package ru.maximov.refactoring

class NewReleasePrice : Price() {
    override fun getPriceCode(): Int = Movie.NEW_RELEASE
}