package jumarket.mercearia.auto.atendimento.service

import jumarket.mercearia.auto.atendimento.entity.Category

interface CategoryService {

    fun save(category: Category): Category

    fun findAll(): List<Category>

    fun delete(id: Long)

}