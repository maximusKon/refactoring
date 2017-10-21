package ru.maximov.refactoring

import java.util.*

class Customer(val name:String) {
    private val rentals : Vector<Rental> = Vector()

    fun addRental(arg:Rental) = rentals::addElement
}