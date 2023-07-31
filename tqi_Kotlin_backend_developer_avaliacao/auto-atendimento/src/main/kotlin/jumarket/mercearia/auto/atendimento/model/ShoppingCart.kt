package jumarket.mercearia.auto.atendimento.model

import jumarket.mercearia.auto.atendimento.entity.Product

data class ShoppingCart(

        val items: MutableMap<Product, Int> = mutableMapOf(),
        var totalAmount: Double = 0.0,

        )