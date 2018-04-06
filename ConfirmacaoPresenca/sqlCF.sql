create database ConfirmacaoPresenca;
use ConfirmacaoPresenca;
CREATE TABLE IF NOT EXISTS Respostas(
id INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(50),
cpf  VARCHAR(20),
email VARCHAR(50),
telefone VARCHAR(50),
presenca boolean default false,
senha VARCHAR(50),

PRIMARY KEY(id))DEFAULT CHARSET=utf8 DEFAULT COLLATE = utf8_general_ci;
use ConfirmacaoPresenca;

ALTER DATABASE ConfirmacaoPresenca DEFAULT CHARACTER SET = utf8 DEFAULT COLLATE = utf8_general_ci;

