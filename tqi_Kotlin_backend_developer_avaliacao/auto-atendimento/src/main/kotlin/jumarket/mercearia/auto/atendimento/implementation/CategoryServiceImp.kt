package jumarket.mercearia.auto.atendimento.implementation

import jumarket.mercearia.auto.atendimento.entity.Category
import jumarket.mercearia.auto.atendimento.exception.BusinessException
import jumarket.mercearia.auto.atendimento.repository.CategoryRepository
import jumarket.mercearia.auto.atendimento.service.CategoryService
import org.springframework.stereotype.Service

@Service
class CategoryServiceImp(private val categoryRepository: CategoryRepository): CategoryService {

    override fun save(category: Category): Category {

        val categoryExists = categoryRepository.findByName(category.name)

        if (categoryExists != null) {
            throw BusinessException("Categoria já existe")
        } else {
            this.categoryRepository.save(category)
        }
        return category
    }

    override fun findAll(): List<Category> = this.categoryRepository.findAll()

    override fun delete(id: Long) {
        categoryRepository.deleteById(id)
    }

}

