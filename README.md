
Auto Atendimento

Este projeto tem por objetivo representar o backend de uma solução para auto atendimento da mercearia JuMarket.

Categorias:

A aplicação é capaz de realizar o cadastro de categorias de produtos.


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/3a0c3ac7-408f-4c36-b494-42f3c5ee0db4)



Também é possível listar todas as categorias cadastradas.



![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/c090f7fa-220f-459b-89aa-a415db580490)



Através do método delete podemos excluir uma categoria existente.


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/0dc06050-abb0-4519-b277-92379ce797dc)



Produtos:

Nossa aplicação também nos permite cadastrar produtos:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/c8aefd3b-f232-473c-a70e-54e397d28f38)


Encontrar um produto pelo seu ID:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/64873dc7-c697-4ef0-8cfc-cdca8bff4f4d)



Excluir um produto pelo seu ID:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/73bcaa2c-4dc7-4876-a487-a6dfbf1af57e)


Atualizar o preço e a quantidade disponível de um produto:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/9d877106-95b5-4ef4-b589-5c142e3b8adb)



Listar todos os produtos cadastrados, note que produtos do mesmo nome caso tenham diferentes unidades de medidas consideramos como distintos: 


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/2b8bd887-d8fb-40c5-8b38-0a44124976f0)




Carrinho de Compras:

É possível adicionar determinada quantidade de um produto ao carrinho, a função addProduct irá validar se existe aquela quantidade para aquele produto e então irá atualizar o estoque, calcular o valor atual do carrinho e retornar as informações atualizadas do carrinho:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/27a0bd73-2f0d-4c07-8154-780a415c8b00)



Também será possível retornar o carrinho com as informações atualizadas:

![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/bcae3356-eb1e-451f-8551-e9ff4bf89fb0)


A função checkout é responsável por finalizar o pedido, o usuário deverá informar um método de pagamento e a função irá retornar o id do pedido, a lista de produtos e o valor total da compra.  


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/e3ebb4ba-f43a-494e-be1d-47c0424eb77e)

