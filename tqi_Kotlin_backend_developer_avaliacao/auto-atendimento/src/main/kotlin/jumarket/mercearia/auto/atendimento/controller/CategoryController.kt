package jumarket.mercearia.auto.atendimento.controller

import jumarket.mercearia.auto.atendimento.dto.CategoryDto
import jumarket.mercearia.auto.atendimento.entity.Category
import jumarket.mercearia.auto.atendimento.implementation.CategoryServiceImp
import jumarket.mercearia.auto.atendimento.repository.CategoryRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController (private val categoryServiceImp: CategoryServiceImp,
                            private val categoryRepository: CategoryRepository){

    @PostMapping
    fun saveCategory(@RequestBody categoryDto: CategoryDto): ResponseEntity<String> {
        val category: Category = this.categoryServiceImp.save(categoryDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria ${category.name} criada com sucesso!")
    }

    @GetMapping
    fun findAllCategory(): ResponseEntity<List<Category>>{
        val allCategory = this.categoryServiceImp.findAll()
        return ResponseEntity.status(HttpStatus.OK).body(allCategory)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") id: Long) {
        categoryRepository.deleteById(id)
    }

}