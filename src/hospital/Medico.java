
/* Diagrama de classes
------------------------
-nome: String
-cpf: int
-codigoDoConselho: int
-endereco: String
-valorDaConsulta: double
------------------------
+cadastrar(medico:Medico): void
+editar(medico:Medico): void
+excluir(medico:Medico): void
+buscarPorCodigo(medico:Medico): Medico
+buscarPorCPF(medico: Medico): Medico
+gerarRelatorio(horario:localDate): Consulta[] */

package hospital;
import java.time.LocalDate;

public class Medico{

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

    public void cadastrar(Medico med){ // Melhorar cadastrar() com a implementação do banco de dados
        this.nome = med.nome; 
        this.cpf = med.cpf;
        this.codigoDoConselho = med.codigoDoConselho;
        this.endereco = med.endereco;
        this.valorDaConsulta = med.valorDaConsulta;
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

    /* void gerarRelatorio(){
        implementar a classe gerarRelatorio() futuramente
    } */

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