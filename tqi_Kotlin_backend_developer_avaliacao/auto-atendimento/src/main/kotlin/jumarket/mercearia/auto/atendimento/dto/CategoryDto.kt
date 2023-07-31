package jumarket.mercearia.auto.atendimento.dto

import jakarta.validation.constraints.NotEmpty
import jumarket.mercearia.auto.atendimento.entity.Category

class CategoryDto (
        @field:NotEmpty(message = "Invalid input")
        val name: String
){
    fun toEntity(): Category = Category(
            name = this.name
    )
}
