package jumarket.mercearia.auto.atendimento.mockito.implementation

import jumarket.mercearia.auto.atendimento.entity.Category
import jumarket.mercearia.auto.atendimento.entity.Product
import jumarket.mercearia.auto.atendimento.exception.BusinessException
import jumarket.mercearia.auto.atendimento.implementation.ProductServiceImp
import jumarket.mercearia.auto.atendimento.repository.CategoryRepository
import jumarket.mercearia.auto.atendimento.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.Optional

class ProductServiceImpTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    @Mock
    private lateinit var  categoryRepository: CategoryRepository

    @InjectMocks
    private lateinit var productServiceImp: ProductServiceImp

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun saveProduct() {
        val category = Category(1,"Bebidas")
        val product = Product(1,"Coca Cola", "2 Litros",10.0, 50,category)
        Mockito.`when`(categoryRepository.findByName(category.name)).thenReturn(category)
        Mockito.`when`(productRepository.findByNameAndUnit(product.name,product.unit)).thenReturn(null)
        Mockito.`when`(productRepository.save(product)).thenReturn(product)
        val savedProduct = productServiceImp.save(product)
        Mockito.verify(productRepository).save(product)
        Assertions.assertEquals(product, savedProduct)
    }
    @Test
    fun savingExistingProduct() {
        val category = Category(1,"Bebidas")
        val product = Product(1,"Coca Cola", "2 Litros",10.0, 50,category)
        val product1 = Product(1,"Coca Cola", "2 Litros",10.0, 100,category)
        Mockito.`when`(categoryRepository.findByName(category.name)).thenReturn(category)
        Mockito.`when`(productRepository.findByNameAndUnit(product.name,product.unit)).thenReturn(product)
        Mockito.`when`(productRepository.save(product1)).thenReturn(product1)
        val savedProduct = productServiceImp.save(product)
        Mockito.verify(productRepository).save(product1)
        Assertions.assertEquals(product1, savedProduct)
    }

    @Test
    fun findByIdExistingProduct() {
        val category = Category(1,"Bebidas")
        val product = Product(1,"Coca Cola", "2 Litros",10.0, 50,category)
        Mockito.`when`(productRepository.findById(product.id)).thenReturn(Optional.of(product))
        val productFound = productServiceImp.findById(product.id)
        Mockito.verify(productRepository).findById(product.id)
        Assertions.assertEquals(product, productFound)
    }

    @Test
    fun findByIdNonExistingProduct() {
        val category = Category(1,"Bebidas")
        val product = Product(1,"Coca Cola", "2 Litros",10.0, 50,category)
        Mockito.`when`(productRepository.findById(product.id)).thenReturn(Optional.empty())
        assertThrows<BusinessException> {productServiceImp.findById(product.id)}
        Mockito.verify(productRepository).findById(product.id)
    }

    @Test
    fun findAll() {
        val category = Category(1,"Bebidas")
        val product = Product(1, "Coca Cola", "2 Litros", 10.0, 50, category)
        val product1 = Product(2, "Coca Cola", "500 ml", 5.0, 100, category)
        val productRepository = Mockito.mock(ProductRepository::class.java)
        val categoryRepository = Mockito.mock(CategoryRepository::class.java)
        Mockito.`when`(productRepository.findAll()).thenReturn(listOf(product, product1))
        val productServiceImp = ProductServiceImp(productRepository, categoryRepository)
        val getAllProducts = productServiceImp.findAll()
        Assertions.assertEquals(2, getAllProducts.size)
        Assertions.assertEquals(product, getAllProducts[0])
        Assertions.assertEquals(product1, getAllProducts[1])
        Mockito.verify(productRepository).findAll()
    }

    @Test
    fun update() {
        val category = Category(1,"Bebidas")
        val product = Product(1,"Coca Cola", "2 Litros",10.0, 50,category)
        val newPrice = 15.0
        val newQuantity = 100
        val updatedProduct = product.copy(price = newPrice, quantity = newQuantity)
        Mockito.`when`(productRepository.findByNameAndUnit(product.name, product.unit)).thenReturn(product)
        Mockito.`when`(productRepository.save(updatedProduct)).thenReturn(updatedProduct)
        val result = productServiceImp.update(updatedProduct)
        Assertions.assertEquals(updatedProduct, result)
        Assertions.assertEquals(newPrice, result.price)
        Assertions.assertEquals(newQuantity, result.quantity)
        Mockito.verify(productRepository, Mockito.times(1)).findByNameAndUnit(product.name, product.unit)
        Mockito.verify(productRepository, Mockito.times(1)).save(updatedProduct)
    }

    @Test
    fun delete() {
        val category = Category(1,"Bebidas")
        val product = Product(1, "Coca Cola", "2 Litros", 10.0, 50, category)
        val productRepository = Mockito.mock(ProductRepository::class.java)
        val categoryRepository = Mockito.mock(CategoryRepository::class.java)
        val productServiceImp = ProductServiceImp(productRepository, categoryRepository)
        Mockito.`when`(productRepository.findById(product.id)).thenReturn(Optional.of(product))
        productServiceImp.delete(product.id)
        Mockito.verify(productRepository).delete(product)
    }
}