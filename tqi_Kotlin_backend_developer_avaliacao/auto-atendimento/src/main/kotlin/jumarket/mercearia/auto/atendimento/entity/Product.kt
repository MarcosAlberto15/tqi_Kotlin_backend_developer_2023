package jumarket.mercearia.auto.atendimento.entity

import jakarta.persistence.*

@Entity
@Table
data class Product(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(nullable = false)
        var name: String = "",

        @Column(nullable = false)
        var unit: String = "",

        @Column(nullable = false)
        var price: Double = 0.0,

        @Column(nullable = false)
        var quantity: Int = 0,

        @ManyToOne
        @JoinColumn(name = "category_id")
        var category: Category = Category()

)
