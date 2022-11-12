CREATE DATABASE IF NOT EXISTS hospital;
use hospital;

CREATE TABLE Medico (nome VARCHAR(40),endereco VARCHAR(50),cpf CHAR(11), idMedico INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(idMedico));
CREATE TABLE Paciente(nome VARCHAR(40),endereco VARCHAR(50), cpf CHAR(11),idPaciente INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(idPaciente));
CREATE TABLE Prontuario(momento DATETIME, obs VARCHAR(100) NOT NULL, idPaciente INT NOT NULL, idProntuario INT NOT NULL AUTO_INCREMENT, FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente), PRIMARY KEY(idProntuario));
CREATE TABLE Consulta(idPaciente INT NOT NULL, idMedico INT NOT NULL, idProntuario INT NOT NULL, idConsulta INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY(idConsulta), FOREIGN KEY(idPaciente) REFERENCES Paciente(idPaciente),FOREIGN KEY(idProntuario) REFERENCES Prontuario(idProntuario),FOREIGN KEY(idMedico) REFERENCES Medico(idMedico)
);
