-- Script de inicialização do banco PostgreSQL para o projeto cadastro-usuario
-- Criado para configurar o banco de dados e as tabelas necessárias

-- Criar o banco de dados (execute como superuser)
-- CREATE DATABASE cadastro;

-- Conectar ao banco cadastro
-- \c cadastro;

-- Criar schema se não existir
CREATE SCHEMA IF NOT EXISTS public;

-- Configurar o schema padrão
SET search_path TO public;

-- Tabela de usuários
CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de livros (alterando de produto para livro)
CREATE TABLE IF NOT EXISTS livro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) UNIQUE NOT NULL,
    autor VARCHAR(255) NOT NULL,
    isbn VARCHAR(20),
    ano_publicacao INTEGER,
    genero VARCHAR(100),
    editora VARCHAR(255),
    descricao TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Criar índices para melhor performance
CREATE INDEX IF NOT EXISTS idx_usuario_email ON usuario(email);
CREATE INDEX IF NOT EXISTS idx_livro_titulo ON livro(titulo);
CREATE INDEX IF NOT EXISTS idx_livro_autor ON livro(autor);
CREATE INDEX IF NOT EXISTS idx_livro_isbn ON livro(isbn);

-- Inserir dados de exemplo (opcional)
INSERT INTO usuario (email, nome) VALUES 
    ('admin@example.com', 'Administrador'),
    ('user@example.com', 'Usuário Teste')
ON CONFLICT (email) DO NOTHING;

INSERT INTO livro (titulo, autor, isbn, ano_publicacao, genero, editora, descricao) VALUES 
    ('Dom Casmurro', 'Machado de Assis', '978-85-359-0277-5', 1899, 'Romance', 'Editora Globo', 'Romance clássico da literatura brasileira'),
    ('O Cortiço', 'Aluísio Azevedo', '978-85-250-4500-0', 1890, 'Romance', 'Editora Ática', 'Romance naturalista brasileiro'),
    ('Capitães da Areia', 'Jorge Amado', '978-85-250-4501-7', 1937, 'Romance', 'Editora Record', 'Romance sobre meninos de rua em Salvador')
ON CONFLICT (titulo) DO NOTHING;

-- Comentários nas tabelas
COMMENT ON TABLE usuario IS 'Tabela para armazenar dados dos usuários do sistema';
COMMENT ON TABLE livro IS 'Tabela para armazenar informações dos livros da biblioteca';

-- Comentários nas colunas principais
COMMENT ON COLUMN usuario.email IS 'Email único do usuário para login';
COMMENT ON COLUMN livro.titulo IS 'Título único do livro';
COMMENT ON COLUMN livro.isbn IS 'Código ISBN do livro';

