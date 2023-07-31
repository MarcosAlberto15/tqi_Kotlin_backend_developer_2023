package jumarket.mercearia.auto.atendimento.controller

import jakarta.validation.Valid
import jumarket.mercearia.auto.atendimento.dto.ProductDto
import jumarket.mercearia.auto.atendimento.entity.Product
import jumarket.mercearia.auto.atendimento.implementation.ProductServiceImp
import jumarket.mercearia.auto.atendimento.repository.CategoryRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product")
class ProductController(private val productServiceImp: ProductServiceImp, private val categoryRepository: CategoryRepository) {

    @PostMapping
    fun saveProduct(@RequestBody @Valid productDto: ProductDto): ResponseEntity<String>{
        val savedProduct = this.productServiceImp.save(productDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto ${savedProduct.name} salvo!")
    }

    @GetMapping("/{id}")
    fun findProductById(@PathVariable(value="id") id: Long): ResponseEntity<Product> {
        val product: Product = this.productServiceImp.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(product)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteProduct(@PathVariable id: Long) = this.productServiceImp.delete(id)

    @PutMapping
    fun updateProduct(@RequestBody @Valid productDto: ProductDto) : ResponseEntity<String> {
        val productToUpdate = productServiceImp.update(productDto.toEntity())
        return ResponseEntity.status(HttpStatus.OK).body("Produto ${productToUpdate.name} atualizado!")
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Product>> {
        val allProducts = productServiceImp.findAll()
        return ResponseEntity.status(HttpStatus.OK).body(allProducts)
    }
}
