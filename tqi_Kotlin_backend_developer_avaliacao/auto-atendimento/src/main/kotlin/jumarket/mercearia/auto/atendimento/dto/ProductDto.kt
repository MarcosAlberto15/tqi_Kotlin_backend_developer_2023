package jumarket.mercearia.auto.atendimento.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jumarket.mercearia.auto.atendimento.entity.Category
import jumarket.mercearia.auto.atendimento.entity.Product

data class ProductDto (
        @field:NotEmpty(message = "Invalid input")
        val name: String,
        @field:NotEmpty(message = "Invalid input")
        val unit: String,
        @field:NotNull(message = "Invalid input")
        val price: Double,
        @field:NotNull(message = "Invalid input")
        val quantity: Int,
        @NotEmpty(message = "Invalid input")
        val category: Category
) {

    fun toEntity(): Product = Product(
            name = this.name,
            unit = this.unit,
            price = this.price,
            quantity = this.quantity,
            category = this.category
    )
}
