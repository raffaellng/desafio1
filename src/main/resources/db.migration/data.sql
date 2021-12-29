CREATE TABLE Cliente(
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    NomeCliente VARCHAR(100),
    CPF VARCHAR(14),
    DataNascimento TIMESTAMP,
    Email VARCHAR(100),
    Usuario VARCHAR(100),
    Senha VARCHAR(max),
    DataCriacao TIMESTAMP,
    DataAlteracao TIMESTAMP,
);

CREATE TABLE Endereco (
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    idCliente INTEGER REFERENCES Cliente(Id),
    Rua VARCHAR(100),
    Numero INTEGER,
    Complemento VARCHAR(20),
    CEP INTEGER,
    Estado VARCHAR(2),
    Pais varchar(20)
);

CREATE TABLE Banco(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    IdCliente INTEGER REFERENCES Cliente(Id),
    TipoConta varchar(),
    Agencia INTEGER(4),
    Conta INTEGER(8),
    Saldo INTEGER(8),
    TipoChave VARCHAR(50),
    Usuario varchar(50),
    Senha VARCHAR(max),
    status BIT,
    DataCriacao TIMESTAMP,
    DataAlteracao TIMESTAMP
);

CREATE TABLE Chaves(
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    TipoChave varchar(50),
    Descricao varchar(100),
    DataCriacao TIMESTAMP,
    Status BIT
)

CREATE TABLE UsuarioChave(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    IdCliente INTEGER REFERENCES Cliente(Id),
    IdBanco INTEGER REFERENCES Branco(Id),
    IdChaves INTEGER REFERENCES Chave(Id),
    Status bit,
    DataStatus TIMESTAMP
)

CREATE TABLE Transacoes(
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    ChaveTrasacao varchar(max),
    Valor integer (8),
    DataTransacao TIMESTAMP,
    IdUsuarioChave INTEGER REFERENCES UsuarioChave(id)
)