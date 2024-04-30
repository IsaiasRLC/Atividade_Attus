-- Insere endereços fictícios
INSERT INTO Endereco (logradouro, cep, numero, cidade, estado) VALUES
('Rua dos Campeões, 123', '12345-678', '123', 'São Paulo', 'SP'),
('Avenida dos Leões, 456', '54321-876', '456', 'Rio de Janeiro', 'RJ'),
('Alameda Azul, 789', '98765-432', '789', 'Belo Horizonte', 'MG'),
('Travessa Verde, 321', '13579-246', '321', 'Porto Alegre', 'RS'),
('Praça do Esporte, 654', '67890-123', '654', 'Curitiba', 'PR');


-- Insere usuários fictícios
INSERT INTO Usuario (nome_completo, data_nascimento, endereco_id) VALUES
('Lucas Pereira', '2001-05-10', 1),
('Carolina Santos', '1999-07-15', 1),
('Rafael Silva', '1997-03-20', 2),
('Juliana Oliveira', '2000-11-25', 3),
('Pedro Almeida', '1994-09-30', 4),
('Fernanda Costa', '1996-01-05', 5),
('Gustavo Santos', '2000-02-12', 2),
('Larissa Oliveira', '2001-08-22', 3),
('Miguel Silva', '1993-12-18', 4),
('Bianca Almeida', '1992-06-08', 5);
