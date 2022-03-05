# X-brain sell challenge

## Premissas:
Criar uma API usando Spring Boot, que faz parte da nossa stack.
Utilizar um banco de dados em memória (HSQLDB ou H2)
Não é necessário desenvolver front-end, apenas o back-end.

## Teste:
Desenvolver um serviço que seja capaz de gerar uma venda.
Uma venda é composta por id, data da venda, valor, vendedor id e vendedor nome.

## Tarefa:
- Desenvolver serviços Rest abaixo:
  - Criar uma nova venda
  - Retornar a lista de vendedores com os campos: nome, total de vendas do vendedor e média de vendas diária, conforme o período informado por parâmetro 

---

### Domain Moddel utilizado para desenvolvimento:

<div align="center">
<img src="https://user-images.githubusercontent.com/70461502/155796405-7803fd24-e5e9-4e79-89ca-bee5823644ef.png" width="700" />
</div>
 
---

### Arquitetura basica a ser utilizada na aplicação

<div align="center">
<img src="https://user-images.githubusercontent.com/70461502/155828528-54f6d8ba-7c77-4f6c-abcf-0e5da546599e.png" width="700" />
</div>

---

### Processo:

- Projeto base criado no [spring initializr](https://start.spring.io/) com as seguintes dependencias:
  - Spring Data JPA
  - Spring Web
  - H2 Database

---
### Formatos de Requisições GET e POST:

- Buscar Pedidos:
  - http://localhost:8080/pedidos
  - http://localhost:8080/pedidos/{id}

- Criar novo Pedido (Venda):
  - http://localhost:8080/pedidos
  - JSON Body: 
 ```json
{
    "vendedor": {
        "id": 1
    },
    "itens": [
        {
            "quantidade": 1,
            "produto": {
                "id": 4
            }
        }
    ]
}
```
- Buscar Vendedores:
  - http://localhost:8080/vendedores
  - http://localhost:8080/vendedores/{id}

- Buscar Vendedor com informacóes de total e média de vendas diária dentro de período informado:
  - http://localhost:8080/vendedores/1/dataInicial={yyyy-MM-dd}/dataFinal={yyyy-MM-dd}
  - exemplo:
    - http://localhost:8080/vendedores/1/dataInicial=2021-02-20/dataFinal=2021-05-05
