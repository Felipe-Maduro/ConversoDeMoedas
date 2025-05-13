# 📊 ConversorDeMoedas

> Conversor de moedas via console que obtém cotações em tempo real de uma API pública.

---

## Índice

* [🚀 Funcionalidades](#-funcionalidades)
* [📋 Requisitos](#-requisitos)
* [⚙️ Instalação](#️-instalação)
* [▶️ Uso](#️-uso)
* [🗂️ Estrutura do Projeto](#️-estrutura-do-projeto)
* [🔧 Configurações](#-configurações)
* [🤝 Contribuição](#-contribuição)
* [⚖️ Licença](#️-licença)

---

## 🚀 Funcionalidades

* 🎛️ Menu interativo com pelo menos **6 pares** de moedas:

  * `USD → EUR`, `EUR → USD`
  * `USD → BRL`, `BRL → USD`
  * `EUR → BRL`, `BRL → EUR`
* 🌐 Cotações dinâmicas via API externa (ExchangeRate-API ou similar).
* ⚠️ Tratamento de erros de rede (`IOException`, `InterruptedException`).
* 🔢 Validação de entrada do usuário (`NumberFormatException`).
* 💡 Formatação de saída em `%.2f` para valores monetários.

---

## 📋 Requisitos

* **Java JDK 11** ou superior
* **Maven 3.6+**
* Conexão com Internet para acessar a API de câmbio

---

## ⚙️ Instalação

1. **Clone** o repositório:

   ```bash
   git clone https://github.com/SEU_USUARIO/ConversorDeMoedas.git
   cd ConversorDeMoedas
   ```
2. **Compile** o projeto:

   ```bash
   mvn clean compile
   ```

---

## ▶️ Uso

### Executando diretamente

```bash
mvn exec:java -Dexec.mainClass="com.exemplo.ConversorDeMoedas"
```

### Gerando JAR

```bash
mvn package
java -cp target/ConversorDeMoedas-1.0-SNAPSHOT.jar com.exemplo.ConversorDeMoedas
```

1. Selecione uma opção do menu.
2. Insira o valor na moeda de origem (use `.` como separador decimal).
3. Veja o resultado formatado na tela.

---

## 🗂️ Estrutura do Projeto

```text
ConversorDeMoedas/
├── .gitignore
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/exemplo/
    │   │       ├── ApiClient.java
    │   │       └── ConversorDeMoedas.java
    │   └── resources/
    └── test/
        └── java/
```

---

## 🔧 Configurações

* **API\_URL**: altere em `ApiClient.java` para outra fonte de cotações.
* **Dependências**: ajuste no `pom.xml` (Jackson, HttpClient Apache, etc.).

---
