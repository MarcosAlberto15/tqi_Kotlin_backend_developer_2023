package jumarket.mercearia.auto.atendimento.entity

import jakarta.persistence.*
import jumarket.mercearia.auto.atendimento.enummeration.Payment
import java.util.UUID

@Entity
@Table(name = "Pedido")
data class Order(

        @Id
        @Column(nullable = false, unique = true)
        val orderNumber: UUID = UUID.randomUUID(),

        @ElementCollection
        @CollectionTable(name = "order_product")
        val products: Map<Product, Int>,

        @Column(nullable = false)
        var totalPrice: Double = 0.0,

        @Enumerated
        @Column(nullable = false)
        var paymentMethod: Payment = Payment.CASH
)
