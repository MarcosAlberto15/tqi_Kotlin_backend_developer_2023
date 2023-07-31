package jumarket.mercearia.auto.atendimento.entity

import jakarta.persistence.*

@Embeddable
data class OrderItems(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    val product: Product,

    @Column(nullable = false)
    val quantity: Int
)
