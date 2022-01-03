CREATE TABLE Cliente(
    Id INTEGER PRIMARY KEY,
    NomeCliente VARCHAR(100),
    CPF VARCHAR(14),
    DataNascimento TIMESTAMP,
    Email VARCHAR(100),
    Status BIT,
    DataCriacao TIMESTAMP,
    DataAlteracao TIMESTAMP
);

CREATE TABLE Banco(
    Id INTEGER PRIMARY KEY,
    IdCliente INTEGER REFERENCES Cliente(Id),
    Instituicao varchar(100),
    TipoConta varchar(10),
    Agencia INTEGER(4),
    Conta INTEGER(8),
    Saldo INTEGER(8),
    Usuario varchar(50),
    Senha VARCHAR(max),
    status BIT,
    DataCriacao TIMESTAMP,
    DataAlteracao TIMESTAMP
);

CREATE TABLE Chaves(
    Id INTEGER PRIMARY KEY,
    TipoChave varchar(50),
    Descricao varchar(200),
    DataCriacao TIMESTAMP,
    Status BIT
);

CREATE TABLE Usuario_Chave(
    id INTEGER PRIMARY KEY,
    IdCliente INTEGER REFERENCES Cliente(Id),
    IdBanco INTEGER REFERENCES Banco(Id),
    IdChaves INTEGER REFERENCES Chaves(Id),
    Chave VARCHAR (100),
    StatusChave bit,
    DataCriacao TIMESTAMP
);

CREATE TABLE Transacoes(
    Id INTEGER PRIMARY KEY,
    ChaveTrasacao VARCHAR(MAX),
    Valor integer (8),
    Observacao VARCHAR (250),
    DataTransacao TIMESTAMP,
    UsuarioOrigem INTEGER REFERENCES Usuario_Chave(id),
    UsuarioDestino INTEGER REFERENCES Usuario_Chave(id)
);