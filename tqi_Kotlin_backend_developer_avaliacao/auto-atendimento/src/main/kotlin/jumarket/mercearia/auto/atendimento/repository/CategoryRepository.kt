package jumarket.mercearia.auto.atendimento.repository

import jumarket.mercearia.auto.atendimento.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category, Long> {

     fun findByName(name: String): Category?

}