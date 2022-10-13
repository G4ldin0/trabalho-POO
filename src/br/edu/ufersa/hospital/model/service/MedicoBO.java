package br.edu.ufersa.hospital.model.service;

public class MedicoBO {
  public void cadastrar(Medico med){ // Melhorar cadastrar() com a implementação do banco de dados
    alterarNome(med.nome);
    alterarCpf(med.cpf);
    alterarCodigoDoConselho(med.codigoDoConselho);
    alterarEndereco(med.endereco);
    alterarValorDaConsulta(med.valorDaConsulta);
}

public void editar(Medico med){
    alterarNome(med.nome);
    alterarCpf(med.cpf);
    alterarCodigoDoConselho(med.codigoDoConselho);
    alterarEndereco(med.endereco);
    alterarValorDaConsulta(med.valorDaConsulta);
}

public void excluir(Medico med){
    med = null;
}

public Medico buscarPorCodigo(Medico med){ // "Medico med" vai ter o med.buscar == codConselho ou cpf buscado
    if (this.codigoDoConselho == med.codigoDoConselho){
        return Medico.this; // Retorna a própria classe
    } else return med; // Alterar esse else?
}

public Medico buscarPorCpf(Medico med){ // "Medico med" vai ter o med.buscar == codConselho ou cpf buscado
    if (this.cpf == med.cpf){
        return Medico.this; // Retorna a própria classe
    } else return med; // Alterar esse else?
}

}
