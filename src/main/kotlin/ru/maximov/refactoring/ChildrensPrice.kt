package ru.maximov.refactoring

class ChildrensPrice : Price() {
    override fun getPriceCode() : Int = Movie.CHILDRENS
}