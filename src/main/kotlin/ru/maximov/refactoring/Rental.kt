package ru.maximov.refactoring

data class Rental(val movie: Movie, private val daysRented: Int){

    fun getCharge(): Double {
        return movie.getCharge(daysRented)
    }

    fun getFrequentRenterPoints(): Int = movie.getFrequentRenterPoints(daysRented)

}