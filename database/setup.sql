-- Script de configuração do banco PostgreSQL
-- Execute este script como superuser (postgres) para criar o banco

-- Criar o banco de dados cadastro
CREATE DATABASE cadastro 
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'pt_BR.UTF-8'
    LC_CTYPE = 'pt_BR.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Comentário no banco
COMMENT ON DATABASE cadastro IS 'Banco de dados para o sistema de cadastro de usuários e livros';

-- Conceder privilégios (opcional - ajuste conforme necessário)
-- GRANT ALL PRIVILEGES ON DATABASE cadastro TO postgres;
-- GRANT ALL PRIVILEGES ON DATABASE cadastro TO seu_usuario;

