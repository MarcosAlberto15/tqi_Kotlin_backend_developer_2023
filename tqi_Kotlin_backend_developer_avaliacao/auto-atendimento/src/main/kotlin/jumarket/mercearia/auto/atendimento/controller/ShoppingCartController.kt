package jumarket.mercearia.auto.atendimento.controller

import jumarket.mercearia.auto.atendimento.entity.Order
import jumarket.mercearia.auto.atendimento.entity.Product
import jumarket.mercearia.auto.atendimento.enummeration.Payment
import jumarket.mercearia.auto.atendimento.implementation.ShoppingCartServiceImp
import jumarket.mercearia.auto.atendimento.model.ShoppingCart
import jumarket.mercearia.auto.atendimento.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shoppingcart")
class ShoppingCartController(private val shoppingCartServiceImp: ShoppingCartServiceImp,
                            private val productRepository: ProductRepository) {

    private var  shoppingCart: ShoppingCart = ShoppingCart()

    @PostMapping("/{quantity}")
    fun addProduct(@RequestBody product: Product, @PathVariable quantity: Int): ResponseEntity<String> {
        shoppingCart = shoppingCartServiceImp.addProduct(product, quantity)
        return ResponseEntity.status(HttpStatus.CREATED).body("$quantity unidades do produto ${product.name} ${product.unit} adicionado ao carrinho!")
    }

    @GetMapping
    fun getCartItems(): ShoppingCart {
        return shoppingCart
    }

    @PostMapping("/checkout")
    fun checkout(@RequestParam payment: Payment): Order {
        return shoppingCartServiceImp.checkout(payment)
    }
}