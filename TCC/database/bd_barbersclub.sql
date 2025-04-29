USE master 
-- IF EXISTS(select * from sys.databases where name='bd_barbersclub')

DROP DATABASE bd_barbersclub
GO 
-- TEM QUE TER O 'GO' AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

CREATE DATABASE bd_barbersclub
GO

USE bd_barbersclub
GO

-- Admin table
CREATE TABLE Admin (
  id INTEGER PRIMARY KEY IDENTITY,
  nome VARCHAR(149) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  senha VARCHAR(25) NOT NULL
);

-- Barbershop table
CREATE TABLE Barbearia ( -- **
  id INT PRIMARY KEY IDENTITY,
  nome VARCHAR(50) NOT NULL, 
  descricao VARCHAR, 
  endereco VARCHAR(255) NOT NULL, 
  admin_id INT, 
  FOREIGN KEY (admin_id) REFERENCES Admin(id)
);

-- Barbers table
CREATE TABLE Barbeiro (
  id INT PRIMARY KEY IDENTITY,
  nome VARCHAR(255) NOT NULL,
  biografia VARCHAR(512),
  especialidades VARCHAR,
  tempoExperiencia INT DEFAULT 0,
  mediaAvaliacao DECIMAL(3,2) DEFAULT 0,
  disponibilidade BIT DEFAULT 1,
  horarioInicial TIME DEFAULT '09:00',
  horarioFinal TIME DEFAULT '18:00',
  criadoEm DATETIME DEFAULT CURRENT_TIMESTAMP,
  atualizadoEm DATETIME DEFAULT CURRENT_TIMESTAMP, 
  barbearia_id INTEGER, 
  FOREIGN KEY (barbearia_id) REFERENCES Barbearia(id)
);

-- Client table
CREATE TABLE Cliente (
  id INTEGER PRIMARY KEY IDENTITY,
  nome VARCHAR(149) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  senha VARCHAR(25) NOT NULL,
  nivelFidelidade VARCHAR(10), -- CHECK(nivelFidelidade IN ('Bronze', 'Prata', 'Ouro')) DEFAULT 'Bronze',
  telefone VARCHAR(15),
  fotoPerfil VARBINARY(MAX),
  criadoEm DATETIME DEFAULT CURRENT_TIMESTAMP,
  atualizadoEm DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Services table
CREATE TABLE Servico (
  id INTEGER PRIMARY KEY IDENTITY,
  nome VARCHAR(25) NOT NULL,
  descricao VARCHAR(255),
  duracao INTEGER NOT NULL,
  preco DECIMAL(5,2) NOT NULL,
  foto VARBINARY(MAX),
  categoria VARCHAR(20) CHECK(categoria IN ('Corte de cabelo', 'Barba', 'Combo', 'Especial')) DEFAULT 'Corte de cabelo',
  pontosGanhos INT DEFAULT 0,
  ativo BIT DEFAULT 1
);

-- Appointments table
CREATE TABLE Agendamento (
  id INT PRIMARY KEY IDENTITY,
  dataAgendamento DATETIME NOT NULL,
  statusAgendamento VARCHAR, -- CHECK(statusAgendamento IN ('Pendente', 'Confirmado', 'Completo', 'Cancelado', 'Não visto')) DEFAULT 'Pendente',
  descricao VARCHAR,
  criadoEm DATETIME DEFAULT CURRENT_TIMESTAMP,
  cliente_id INT NOT NULL,
  barbeiro_id INT NOT NULL,
  servico_id INT NOT NULL,
  FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
  FOREIGN KEY (barbeiro_id) REFERENCES Barbeiro(id),
  FOREIGN KEY (servico_id) REFERENCES Servico(id)
);

-- Fidelity points table
CREATE TABLE PontosFidelidade ( -- **
  id INTEGER PRIMARY KEY IDENTITY,
  pontos INTEGER NOT NULL,
  tipoTransacao VARCHAR, -- CHECK(tipoTransacao IN ('Ganho', 'Gasto', 'Expirado', 'Bônus')) NOT NULL, -- **
  descricao VARCHAR,
  criadoEm DATETIME DEFAULT CURRENT_TIMESTAMP,
  referencia_id INT,
  cliente_id INTEGER NOT NULL,
  FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

-- Chat messages table
CREATE TABLE MensagensChat (
  id INTEGER PRIMARY KEY IDENTITY,
  mensagem VARCHAR(255) NOT NULL,
  lida BIT DEFAULT 0,
  mensagemBot BIT DEFAULT 0,
  iniciadoEm DATETIME DEFAULT CURRENT_TIMESTAMP,
  remetente_id INTEGER NOT NULL,
  destinatario_id INTEGER NOT NULL,
  FOREIGN KEY (remetente_id) REFERENCES Cliente(id),
  FOREIGN KEY (destinatario_id) REFERENCES Admin(id) -- quem recebe é o Barbeiro ou o Admin?
);


-- Insert sample atributes

INSERT INTO Admin (nome, email, senha) 
VALUES
('zurC ordnaeL', 'ordnaelzurc@liamg.moc', 101112),
('João Gomes, aquele que tá na voz', 'joaogomes.aqueleqtanavoz@gmail.com', 102030),
('Ana Maria Bragança Paulista', 'bragancapaulista.anamaria@hotmail.com', 405060)

INSERT INTO Barbearia (nome, endereco, admin_id) 
VALUES
('Barbearia Lopes', 'Avenida 020 - Alphaville Comercial', 3),
('Espaço Na Régua', 'Avenida São Cristóvão, 123 - Teresina', 2),
('Fala Zééé', 'Rua Modesta, n° do Zé', 1)

INSERT INTO Barbeiro (nome, biografia, tempoExperiencia, barbearia_id) 
VALUES
('Chuuuuuva Minino', 'A chuva nos seus cabelos!', 3, 2),
('Ivan Rodrigues', 'EU NUM SEEEEEEEEEEEEI', 0.6, 3),
('Ana Ruby', 'Transformo seus cabelos em rubis! (LITERALMENTE)', 9, 1)

INSERT INTO Cliente (nome, email, senha, nivelFidelidade, telefone) 
VALUES
('Seu Antonhu', 'seuantonhu@outlook.com.br', 'seViraAi', 'Prata', '89 91234-5678'),
('Num sei meu fi', 'numseimeufi@gmail.com', '1234567654321', 'Prata', '11 91234-5690'),
('Mais um ser humano... ou não', 'maisumserhumano.ounao@gmail.com', 'abcdefgh...', 'Ouro', '11 5987-6543')

INSERT INTO Servico (nome, descricao, duracao, preco, categoria, pontosGanhos) 
VALUES
('Corte Social', 'Corte de cabelo Premium com serviço de toalhas quentes', 45, 45.00, 'Corte de cabelo', 45),
('Barba Navalhada', 'Barba tradicional com corte navalhado reto', 30, 35.00, 'Barba', 35),
('Barba Esculpida', 'Corte e modelagem de barba profissional', 30, 30.00, 'Barba', 30),
('Pacote VIP', 'Corte de cabelo e depilação e tratamento facial', 90, 89.00, 'Combo', 100) -- ** tá ligaaaaaaadooo

INSERT INTO Agendamento (dataAgendamento, cliente_id, barbeiro_id, servico_id) 
VALUES
(1010-10-10, 1, 1, 2),
(1111-11-11, 1, 2, 3),
(2025-04-28, 3, 3, 4)

INSERT INTO PontosFidelidade (pontos, cliente_id) 
VALUES
(1500, 3),
(2000000, 2),
(5, 1)

INSERT INTO MensagensChat (mensagem, remetente_id, destinatario_id) 
VALUES
('Oi, tudo bem? Daqui a pouco eu respondo.', 1, 2),
('Aoba... PAYSANDÚUUUUuuuUUUU', 2, 1),
('Salve! Un tè, per favore.', 3, 3)

 -- Verify an example of insertion
SELECT * FROM Admin
SELECT * FROM Barbearia
SELECT * FROM Barbeiro
SELECT * FROM Cliente
SELECT * FROM Agendamento
SELECT * FROM PontosFidelidade
SELECT * FROM MensagensChat
SELECT * FROM Servico
SELECT * FROM Servico WHERE id = '1'

-- SELECT nome, descricao, duracao, preco, foto, categoria, pontosGanhos, ativo FROM Servico WHERE id = '1'

