package ru.maximov.refactoring

class ChildrensPrice : Price() {
    override fun getPriceCode() : Int = Movie.CHILDRENS

    override fun getCharge(daysRented: Int): Double {
        var result = 1.5
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5
        return result
    }
}