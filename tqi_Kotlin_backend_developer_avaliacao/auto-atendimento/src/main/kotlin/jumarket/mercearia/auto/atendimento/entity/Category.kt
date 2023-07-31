package jumarket.mercearia.auto.atendimento.entity

import jakarta.persistence.*

@Entity
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

)
