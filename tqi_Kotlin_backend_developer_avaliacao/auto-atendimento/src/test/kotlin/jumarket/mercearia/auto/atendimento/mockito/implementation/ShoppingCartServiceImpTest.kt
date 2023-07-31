package jumarket.mercearia.auto.atendimento.mockito.implementation

import jumarket.mercearia.auto.atendimento.entity.Category
import jumarket.mercearia.auto.atendimento.entity.Product
import jumarket.mercearia.auto.atendimento.model.ShoppingCart
import jumarket.mercearia.auto.atendimento.implementation.ShoppingCartServiceImp
import jumarket.mercearia.auto.atendimento.repository.OrderRepository
import jumarket.mercearia.auto.atendimento.repository.ProductRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ShoppingCartServiceImpTest {

    @InjectMocks
    private lateinit var shoppingCartServiceImp: ShoppingCartServiceImp

    @Mock
    private lateinit var productRepository: ProductRepository

    @Mock
    private lateinit var orderRepository: OrderRepository

    private lateinit var shoppingCart: ShoppingCart

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        shoppingCart = ShoppingCart()
    }

    @Test
    fun addingProductSuccessfully() {
        val category = Category(1,"Bebidas")
        val product = Product(1, "Coca Cola", "2 Litros", 10.0, 50, category)
        val quantity = 5
        Mockito.`when`(productRepository.findByNameAndUnit("Coca Cola", "2 Litros")).thenReturn(product)
        shoppingCartServiceImp.addProduct(product, quantity)
        Mockito.verify(productRepository, Mockito.times(1)).findByNameAndUnit("Coca Cola", "2 Litros")
    }

    @Test
    fun getCartItems() {
    }

    @Test
    fun checkout() {
    }

    @Test
    fun updateTotalPrice() {
    }

    @Test
    fun clearCart() {
    }
}