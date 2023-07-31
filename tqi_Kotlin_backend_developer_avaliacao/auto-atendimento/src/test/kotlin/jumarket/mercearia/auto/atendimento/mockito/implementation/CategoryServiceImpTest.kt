package jumarket.mercearia.auto.atendimento.mockito.implementation

import jumarket.mercearia.auto.atendimento.entity.Category
import jumarket.mercearia.auto.atendimento.exception.BusinessException
import jumarket.mercearia.auto.atendimento.implementation.CategoryServiceImp
import jumarket.mercearia.auto.atendimento.repository.CategoryRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CategoryServiceImpTest {

    @Mock
    private lateinit var categoryRepository: CategoryRepository

    @InjectMocks
    private lateinit var categoryServiceImp: CategoryServiceImp

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun saveCategory() {
        val categoryTest = Category(1,"Bebidas")
        Mockito.`when`(categoryRepository.findByName(categoryTest.name)).thenReturn(null)
        val savedCategory = categoryServiceImp.save(categoryTest)
        Assertions.assertNotNull(savedCategory)
    }

    @Test
    fun saveCategoryAlreadyExists() {
        val categoryTest = Category(1,"Bebidas")
        Mockito.`when`(categoryRepository.findByName(categoryTest.name)).thenReturn(categoryTest)
        Assertions.assertThrows(BusinessException::class.java) {categoryServiceImp.save(categoryTest)}
        Mockito.verify(categoryRepository, Mockito.never()).save(Mockito.any())
    }

    @Test
    fun findAll() {
        val category1 = Category(1,"Bebidas")
        val category2 = Category(2,"Alimentos")
        val category3 = Category(3,"Cosméticos")
        val getCategories = listOf(category1, category2, category3)
        Mockito.`when`(categoryRepository.findAll()).thenReturn(getCategories)
        val categories = categoryServiceImp.findAll()
        Assertions.assertEquals(getCategories, categories)

    }
    @Test
    fun delete() {
        val category = Category(1,"Bebidas")
        categoryServiceImp.delete(category.id)
        Mockito.verify(categoryRepository).deleteById(category.id)
    }

}