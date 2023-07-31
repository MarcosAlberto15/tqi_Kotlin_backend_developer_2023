package jumarket.mercearia.auto.atendimento.repository

import jumarket.mercearia.auto.atendimento.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {

    fun findByNameAndUnit(name: String, unit: String): Product?

}