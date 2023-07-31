package jumarket.mercearia.auto.atendimento.implementation

import jumarket.mercearia.auto.atendimento.entity.Product
import jumarket.mercearia.auto.atendimento.exception.BusinessException
import jumarket.mercearia.auto.atendimento.repository.CategoryRepository
import jumarket.mercearia.auto.atendimento.repository.ProductRepository
import jumarket.mercearia.auto.atendimento.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImp(private val productRepository: ProductRepository,
                    private val categoryRepository: CategoryRepository): ProductService {


    override fun save(product: Product): Product {
        categoryRepository.findByName(product.category.name)?: throw BusinessException("Categoria não existe")
        productRepository.findByNameAndUnit(product.name, product.unit)?.let { existingProduct ->
            existingProduct.quantity += product.quantity
            productRepository.save(existingProduct)
        } ?: productRepository.save(product)
        return product
    }

    override fun findById(id: Long): Product = this.productRepository.findById(id).orElseThrow {
        throw BusinessException("Produto não encontrado com o ID $id!")
    }

    override fun findAll(): List<Product> {
        val productList = productRepository.findAll()
        if(productList.isNullOrEmpty()) {
            throw BusinessException("Nenhum produto cadastrado!")
        }
        return productList
    }

    override fun update(product: Product): Product {
        productRepository.findByNameAndUnit(product.name, product.unit)?.run {
            this.price = product.price
            this.quantity = product.quantity
            productRepository.save(this)
        } ?: throw BusinessException ("Produto não encontrado!")
        return product
    }

    override fun delete(id: Long) {
        val product: Product = this.findById(id)
                this.productRepository.delete(product)
    }
}