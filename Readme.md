# **Sistema de Notificações - Desafio de Projeto DIO & GFT**

Este projeto é uma API REST desenvolvida em Spring Boot como parte do Desafio de Projeto **"Explorando Padrões de Projetos na Prática com Java"**, oferecido pela **Digital Innovation One** em parteria com a **GFT**.

O objetivo foi criar um sistema flexível e de fácil manutenção para o envio de diferentes tipos de notificações (`Email`, `SMS` e `Push`), aplicando na prática os conceitos de **Design Patterns**.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Maven**

---

## 🧩 Padrões de Projeto Aplicados

Este projeto foi estruturado para exemplificar quatro padrões de projeto essenciais que trabalham em conjunto para criar uma solução robusta e desacoplada.

### 1. **Singleton**
> Garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a ela.

- **Aplicação no Projeto**:  
  O Spring Framework gerencia componentes como `Singletons` por padrão. Classes anotadas com `@Service`, `@RestController` e `@Repository` são instanciadas uma única vez pelo contêiner de Injeção de Dependências (IoC).  
  - *Exemplos*:  
    `NotificacaoFacade` e implementações de `NotificacaoStrategy` (`EmailStrategyImpl`, etc.) são `Singletons` gerenciados pelo Spring.

---

### 2. **Builder**
> Padrão criacional que permite a construção de objetos complexos passo a passo, melhorando legibilidade e flexibilidade.

- **Aplicação no Projeto**:  
  Utilizado na classe `Notificacao` para criar instâncias de forma fluente, evitando construtores com múltiplos parâmetros.  
  ```java
  // Exemplo no NotificacaoController:
  Notificacao notificacao = new Notificacao.Builder()
          .para(request.getDestinatario())
          .comTitulo(request.getTitulo())
          .comMensagem(request.getMensagem())
          .doTipo(request.getTipo())
          .construir();
  ```

---

### 3. **Strategy**
> Padrão comportamental que define uma família de algoritmos intercambiáveis encapsulados em classes separadas.

- **Aplicação no Projeto**:  
  Define diferentes formas de envio de notificações:  
  - Interface `NotificacaoStrategy` define o contrato.
  - Classes `EmailStrategyImpl`, `SmsStrategyImpl` e `PushStrategyImpl` implementam estratégias concretas.  
  *Permite adicionar novos métodos (ex: WhatsApp) sem alterar o código existente.*

---

### 4. **Facade**
> Padrão estrutural que fornece uma interface simplificada para um subsistema complexo.

- **Aplicação no Projeto**:  
  A classe `NotificacaoFacade` atua como fachada:  
  - Esconde a complexidade de selecionar a `Strategy` correta.
  - O `NotificacaoController` entrega o objeto `Notificacao` sem conhecer detalhes de implementação.  
  ```java
  // Fluxo simplificado:
  controller → facade → strategy (concreta)
  ```

---

## ▶️ Como Executar

1. Clone este repositório:
   ```bash
   git clone [URL_DO_REPOSITÓRIO]
   ```

2. Abra um terminal na pasta raiz do projeto.

3. Execute o comando:
   ```bash
   mvn spring-boot:run
   ```

4. O servidor estará disponível em:  
   🔗 http://localhost:8080

---

## 🧪 Como Testar a API

Envie uma requisição `POST` para o endpoint:  
`http://localhost:8080/notificacoes/enviar`

### Exemplo com `cURL`:
```bash
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{
        "destinatario": "exemplo@email.com",
        "titulo": "Teste de API",
        "mensagem": "Isso é um teste de notificação.",
        "tipo": "EMAIL"
      }' \
  http://localhost:8080/notificacoes/enviar
```

### Teste outros tipos:
- Altere `"tipo"` para `"SMS"` ou `"PUSH"`.

---

> **Nota**: Este projeto demonstra a aplicação prática de padrões de projeto para criar uma solução escalável e de fácil manutenção. ✨
