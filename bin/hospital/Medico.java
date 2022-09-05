/* Diagrama de classes
------------------------
+nome: String
+cpf: int
+codigoDoConselho: int
+endereco: String
+valorDaConsulta: double
------------------------
+cadastrar(medico:Medico): void
+editar(medico:Medico): void
+excluir(medico:Medico): void
+buscarPorCodigo(medico:Medico): Medico
+buscarPorCPF(medico: Medico): Medico
+gerarRelatorio(horario:localDate): Consulta[] */

class Medico{

    private String nome;
    private int cpf;
    private int codigoDoConselho;
    private String endereco;
    private double valorDaConsulta;

    public Medico(){}

    public Medico(String nome, int cpf, int codConselho, String endereco, double valorConsulta){
        this.nome = nome;
        this.cpf = cpf;
        this.codigoDoConselho = codConselho;
        this.endereco = endereco;
        this.valorDaConsulta = valorConsulta;
    }

    public Medico(String nome, int cpf, int codConselho, double valorConsulta){
        this.nome = nome;
        this.cpf = cpf;
        this.codigoDoConselho = codConselho;
        this.endereco = "Condomínio dos Médicos";
        this.valorDaConsulta = valorConsulta;
    }

    public Medico(String nome, int cpf, int codConselho){
        this.nome = nome;
        this.cpf = cpf;
        this.codigoDoConselho = codConselho;
        this.endereco = "Condomínio dos Médicos";
        this.valorDaConsulta = 5499.99;  // Valor padrão do hospital
    }

    public Medico(int buscar){
        this.cpf = buscar;
        this.codigoDoConselho = buscar;
    }

    void cadastrar(Medico med){
        this.nome = med.nome;
        this.cpf = med.cpf;
        this.codigoDoConselho = med.codigoDoConselho;
        this.endereco = med.endereco;
        this.valorDaConsulta = med.valorDaConsulta;
    }

    void editar(Medico med){
        alterarNome(med.nome);
        alterarCpf(med.cpf);
        alterarCodigoDoConselho(med.codigoDoConselho);
        alterarEndereco(med.endereco);
        alterarValorDaConsulta(med.valorDaConsulta);
    }

    void excluir(Medico med){
        med = null;
    }

    Medico buscarPorCodigo(Medico med){
        if (this.codigoDoConselho == med.codigoDoConselho){
            return Medico; // (TO DO) Fazer retornar a própria classe
        } else return 0;
    }

    Medico buscarPorCpf(Medico med){
        if (this.cpf == med.cpf){
            return Medico; // (TO DO) Fazer retornar a própria classe
        } else return 0;
    }

    // Getters e Setters abaixo. Setters tem o nome de "alterar". Ex: setNome() -> alterarNome()

    public String getNome() { 
        return nome;
    }

    public void alterarNome(String nome) {  // setNome()
        if (nome == " "){
            System.out.println("Esse nome é inválido.");
        } else this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void alterarCpf(int cpf) {   // setCpf()
        if (cpf == 0){
            System.out.println("Cpf inválido.");
        } else this.cpf = cpf;
    }

    public int getCodigoDoConselho() {
        return codigoDoConselho;
    }

    public void alterarCodigoDoConselho(int codigoDoConselho) { // setCodigoDoConselho()
        if (cpf == 0){
            System.out.println("Código do conselho inválido.");
        } else this.codigoDoConselho = codigoDoConselho;
    }

    public String getEndereco() {
        return endereco;
    }

    public void alterarEndereco(String endereco) {  // setEndereco()
        if (endereco == " "){
            System.out.println("Endereço inválido.");
        } else this.endereco = endereco;
    }
    
    public double getValorDaConsulta() {
        return valorDaConsulta;
    }

    public void alterarValorDaConsulta(double valorDaConsulta) {    // setValorDaConsulta()
        if (valorDaConsulta == 0){
            System.out.println("Valor da consulta inválido.");
        } else this.valorDaConsulta = valorDaConsulta;
    }


}