package jumarket.mercearia.auto.atendimento.repository

import jumarket.mercearia.auto.atendimento.entity.Order
import jumarket.mercearia.auto.atendimento.entity.Product
import jumarket.mercearia.auto.atendimento.model.ShoppingCart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderRepository: JpaRepository<Order, UUID> {
    fun save(order: Order)
}