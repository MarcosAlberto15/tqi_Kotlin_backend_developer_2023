package jumarket.mercearia.auto.atendimento.implementation

import jumarket.mercearia.auto.atendimento.entity.Order
import jumarket.mercearia.auto.atendimento.entity.Product
import jumarket.mercearia.auto.atendimento.model.ShoppingCart
import jumarket.mercearia.auto.atendimento.enummeration.Payment
import jumarket.mercearia.auto.atendimento.exception.BusinessException
import jumarket.mercearia.auto.atendimento.repository.OrderRepository
import jumarket.mercearia.auto.atendimento.repository.ProductRepository
import jumarket.mercearia.auto.atendimento.service.ShoppingCartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.IllegalArgumentException

@Service
class ShoppingCartServiceImp(private val orderRepository: OrderRepository,
                        private val productRepository: ProductRepository): ShoppingCartService {

    private val products = Product()

    private var  shoppingCart = ShoppingCart()

    override fun addProduct(product: Product, quantity: Int): ShoppingCart {
        val findProduct = productRepository.findByNameAndUnit(product.name, product.unit)
                ?: throw BusinessException("Produto não encontrado: ${product.name} (${product.unit})")

        if(findProduct.quantity < quantity) {
            throw IllegalArgumentException("Estoque Indisponível!")
        }

        shoppingCart.items[findProduct] = shoppingCart.items.getOrDefault(findProduct, 0) + quantity

        findProduct.quantity -= quantity
        productRepository.save(findProduct)

        val productTotalPrice = findProduct.price * quantity
        shoppingCart.totalAmount += productTotalPrice

        return shoppingCart
    }

    override fun getCartItems(): ShoppingCart {
        return shoppingCart
    }

    override fun checkout(payment: Payment): Order {
        val order = Order(
                products = shoppingCart.items.toMap(),
                totalPrice = shoppingCart.totalAmount,
                paymentMethod = payment
        )
        val finishedOrder = orderRepository.save(order)

        return order
    }

}