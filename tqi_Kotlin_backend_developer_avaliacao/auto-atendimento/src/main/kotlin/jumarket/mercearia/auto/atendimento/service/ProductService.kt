package jumarket.mercearia.auto.atendimento.service

import jumarket.mercearia.auto.atendimento.entity.Product

interface ProductService {

    fun save(product: Product): Product

    fun findById(id: Long): Product

    fun findAll(): List<Product>

    fun update(product: Product): Product

    fun delete(id: Long)

}
