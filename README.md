<img width="336" alt="image" src="https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/0e42a11f-e225-43fc-9751-0283f6bac97f">

Auto Atendimento

Este projeto tem por objetivo representar o backend de uma solução para auto atendimento da mercearia JuMarket.

Categorias:

A aplicação é capaz de realizar o cadastro de categorias de produtos.


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/9ee29e68-7b99-4cd0-8a53-18bffae0a696)


Também é possível listar todas as categorias cadastradas.



![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/f69422ba-01ed-4b22-bce4-be3c498b622c)


Através do método delete podemos excluir uma categoria existente.


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/16bafd02-f9a5-464b-93a3-37e2a79906df)


Produtos:

Nossa aplicação também nos permite cadastrar produtos:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/05ec84a3-1041-462d-8e67-8dfad2a0c9ba)



Encontrar um produto pelo seu ID:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/f520a8f6-f38c-4425-bb8b-24189747dabb)


Excluir um produto pelo seu ID:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/c44c6beb-e019-4e81-8d64-82590af9619a)


Atualizar o preço e a quantidade disponível de um produto:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/9a3d612d-5bcf-41db-85ea-dd04a5edf491)


Listar todos os produtos cadastrados, note que produtos do mesmo nome caso tenham diferentes unidades de medidas consideramos como distintos: 


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/f849f9a2-a934-46cf-bedb-cc06e6e91982)



Carrinho de Compras:

É possível adicionar determinada quantidade de um produto ao carrinho, a função addProduct irá validar se existe aquela quantidade para aquele produto e então irá atualizar o estoque, calcular o valor atual do carrinho e retornar as informações atualizadas do carrinho:


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/36feb5f2-2b85-401e-8e3a-76fa6440e3cf)


Também será possível retornar o carrinho com as informações atualizadas:

![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/47a6a543-5ff5-4eb4-a2e5-e01a0fb05a92)


A função checkout é responsável por finalizar o pedido, o usuário deverá informar um método de pagamento e a função irá retornar o id do pedido, a lista de produtos e o valor total da compra.  


![image](https://github.com/MarcosAlberto15/tqi_Kotlin_backend_developer_avaliacao/assets/109168482/0e13fd96-2b6c-432d-acd1-9ea4e7235c24)
