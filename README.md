# 🧪 Testes Unitários — Sistema de Produtos e Vendas

## 🎯 Objetivo  
Garantir a **qualidade**, **consistência** e **robustez** do sistema de gerenciamento de produtos e vendas, assegurando **90% ou mais de cobertura de código**.

---

## 📋 Escopo dos Testes

### ✅ Criação de Produto
- [x] Testar criação de produto com **valores válidos**.  
- [x] Testar criação de produto com **preço negativo** (deve ser inválido).  
- [x] Testar criação de produto com **estoque negativo** (deve ser inválido).  

---

### 🔄 Alteração de Produto
- [x] Testar **alteração do nome** do produto para um valor válido.  
- [x] Testar **alteração do preço** do produto para um valor válido.  
- [x] Testar **alteração do estoque** para um valor positivo.  
- [x] Testar **alteração do preço** do produto para um valor **negativo** (deve falhar).  

---

### 💰 Testes de Vendas
- [x] Testar **venda com quantidade menor** que o estoque disponível.  
- [x] Testar **venda com quantidade igual** ao estoque disponível.  
- [x] Testar **venda com quantidade maior** que o estoque disponível (deve falhar).  
- [x] Testar **cálculo do total da venda** corretamente.  
- [x] Testar **diminuição do estoque** do produto após uma venda bem-sucedida.  
- [x] Testar **aumento do estoque** do produto após uma venda (caso de reposição).  
- [x] Testar **venda de produto inexistente** (deve falhar).  
- [x] Testar **criação de venda com quantidade negativa** (deve falhar).  
- [x] Testar **alteração do estoque** após tentativa de venda com estoque insuficiente.  
- [x] Testar **comportamento da venda com estoque inicial zero**.  
- [x] Testar **venda após reposição** e verificar sucesso.  

---

### 🧩 Testes Avançados
- [ ] Testar **criação de vários produtos** e realizar **vendas com estoque compartilhado**.  
- [ ] Testar **cálculo do total da venda** quando o **preço do produto for alterado antes da venda**.  

---

## 📊 Meta de Cobertura
- **Cobertura mínima:** 90%  
- **Ferramenta recomendada:** JaCoCo (para projetos Maven ou Gradle).  

---

## ⚙️ Requisitos Técnicos
- **Linguagem:** Java  
- **Framework de Teste:** JUnit 5  
- **Build:** Maven ou Gradle  
- **Padrão de nomes:** `NomeClasseTest.java`  
- **Isolamento:** Utilizar mocks ou stubs quando necessário.  



