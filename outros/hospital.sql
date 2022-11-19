CREATE DATABASE IF NOT EXISTS hospital;
use hospital;

CREATE TABLE IF NOT EXISTS usuario (username VARCHAR(30), senha VARCHAR(30));
CREATE TABLE IF NOT EXISTS adm (username VARCHAR(30), senha VARCHAR(30));
CREATE TABLE IF NOT EXISTS Medico (nome VARCHAR(40),endereco VARCHAR(50),cpf CHAR(11),valorDaConsulta DECIMAL,codigoDoConselho INT NOT NULL, idMedico INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(idMedico));
CREATE TABLE IF NOT EXISTS Paciente(nome VARCHAR(40),endereco VARCHAR(50), cpf CHAR(11), idade CHAR(11), idPaciente INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(idPaciente));
CREATE TABLE IF NOT EXISTS Prontuario(dia DATE,horario TIME, obs VARCHAR(100) NOT NULL, idPaciente INT NOT NULL, idProntuario INT NOT NULL AUTO_INCREMENT, FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente), PRIMARY KEY(idProntuario));
CREATE TABLE IF NOT EXISTS Consulta(dia DATE, horario TIME,idPaciente INT NOT NULL, idMedico INT NOT NULL, idProntuario INT NOT NULL, idConsulta INT NOT NULL AUTO_INCREMENT,PRIMARY KEY(idConsulta), FOREIGN KEY(idPaciente) REFERENCES Paciente(idPaciente),FOREIGN KEY(idProntuario) REFERENCES Prontuario(idProntuario),FOREIGN KEY(idMedico) REFERENCES Medico(idMedico));
