package ru.maximov.refactoring

class Movie {

    val title:String
    private lateinit var price: Price

    var priceCode:Int
        get() = price.getPriceCode()
        set(value) {
            when(value){
                Movie.REGULAR -> price = RegularPrice()
                Movie.CHILDRENS -> price = ChildrensPrice()
                Movie.NEW_RELEASE -> price = NewReleasePrice()
            }
        }

    constructor(title: String, priceCode: Int){
        this.title = title
        this.priceCode = priceCode
    }

    companion object {
        const val CHILDRENS = 2
        const val REGULAR = 0
        const val NEW_RELEASE = 1
    }

    fun getCharge(daysRented: Int): Double = price.getCharge(daysRented)


    fun getFrequentRenterPoints(daysRented: Int): Int =
            price.getFrequentRenterPoints(daysRented)
}