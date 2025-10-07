# Configuração do Banco PostgreSQL

Este diretório contém os scripts SQL necessários para configurar o banco de dados PostgreSQL para o projeto cadastro-usuario.

## Arquivos

- `setup.sql` - Script para criar o banco de dados
- `init.sql` - Script para criar as tabelas e inserir dados iniciais

## Como usar

### 1. Criar o banco de dados

Execute o script `setup.sql` como superuser (postgres):

```bash
psql -U postgres -f database/setup.sql
```

### 2. Criar as tabelas

Conecte ao banco `cadastro` e execute o script `init.sql`:

```bash
psql -U postgres -d cadastro -f database/init.sql
```

### 3. Verificar a configuração

Para verificar se tudo foi criado corretamente:

```bash
psql -U postgres -d cadastro -c "\dt"
```

## Configuração da aplicação

Certifique-se de que o arquivo `application.properties` está configurado corretamente:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cadastro
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## Tabelas criadas

- `usuario` - Armazena dados dos usuários
- `livro` - Armazena informações dos livros (alterado de "produto")

## Dados de exemplo

O script `init.sql` inclui alguns dados de exemplo para testar a aplicação.

