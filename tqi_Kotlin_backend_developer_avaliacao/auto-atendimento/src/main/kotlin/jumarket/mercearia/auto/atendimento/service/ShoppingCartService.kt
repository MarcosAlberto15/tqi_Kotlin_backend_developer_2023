package jumarket.mercearia.auto.atendimento.service

import jumarket.mercearia.auto.atendimento.entity.Order
import jumarket.mercearia.auto.atendimento.entity.Product
import jumarket.mercearia.auto.atendimento.enummeration.Payment
import jumarket.mercearia.auto.atendimento.model.ShoppingCart

interface ShoppingCartService {

    fun addProduct(product: Product, quantity: Int): ShoppingCart

    fun getCartItems(): ShoppingCart

    fun checkout(payment: Payment): Order

}