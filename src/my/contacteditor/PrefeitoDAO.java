/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

import my.contacteditor.conexao.conexaoBD;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author  Lucas Tassi
 *          Lucas Diniz
 *          Lucas Barbosa
 *          Jhordan Garcia
 */
public class PrefeitoDAO {

    private String cpf;
    private String nomeReal;
    private String nomeFantasia;
    private String rg;
    private String telefone1;
    private String telefone2;
    private String nomeVice;
    private String rua;
    private String bairro;
    private String numeroRua;
    private String cep;
    private String cidade;
    private String estado;
    private String tituloEleitor;
    private String sexo;
    private String dataNasc;
    private String ufNasc;
    private String orgaoEmissor;
    private int numeroCampanha;
    private int numeroCampanhaVice;
    private String partido;
    
    public PrefeitoDAO(String cpf, String nomeReal, String nomeFantasia, String rg, String telefone1, 
            String telefone2, String nomeVice, String rua,String bairro,String numeroRua, String cep, String cidade, 
            String estado, String tituloEleitor, String sexo, String dataNasc, String ufNasc, String orgaoEmissor, 
            int numeroCampanha, int numeroCampanhaVice,String partido) {
         this.cpf = cpf;
         this.nomeReal = nomeReal;
         this.nomeFantasia = nomeFantasia;
         this.nomeVice = nomeVice;
         this.numeroCampanha = numeroCampanha;
         this.numeroCampanhaVice = numeroCampanhaVice;
         this.ufNasc = ufNasc;
         this.partido = partido;
         this.bairro = bairro;
         this.rg = rg;
         this.cep = cep;
         this.dataNasc = dataNasc;
         this.cidade = cidade;
         this.estado = estado;
         this.numeroRua = numeroRua;
         this.orgaoEmissor = orgaoEmissor;
         this.rua = rua;
         this.sexo = sexo;
         this.telefone1 = telefone1;
         this.telefone2 = telefone2;
         this.tituloEleitor = tituloEleitor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeReal() {
        return nomeReal;
    }

    public void setNomeReal(String nomeReal) {
        this.nomeReal = nomeReal;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getNomeVice() {
        return nomeVice;
    }

    public void setNomeVice(String nomeVice) {
        this.nomeVice = nomeVice;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumeroRua() {
        return numeroRua;
    }

    public void setNumeroRua(String numeroRua) {
        this.numeroRua = numeroRua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getUfNasc() {
        return ufNasc;
    }

    public void setUfNasc(String ufNasc) {
        this.ufNasc = ufNasc;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public int getNumeroCampanha() {
        return numeroCampanha;
    }

    public void setNumeroCampanha(int numeroCampanha) {
        this.numeroCampanha = numeroCampanha;
    }

    public int getNumeroCampanhaVice() {
        return numeroCampanhaVice;
    }

    public void setNumeroCampanhaVice(int numeroCampanhaVice) {
        this.numeroCampanhaVice = numeroCampanhaVice;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
    

    
    public PrefeitoDAO(){
        /*Utilizado nos testes (Classe PigLatinTest)*/
    }

    
    public boolean inserePrefeito() throws entradaInvalidaException, SQLException{
        conexaoBD conexao = new conexaoBD();
         
        try{
            conexao.insereDados(this);
            return true;
        }
        catch(Exception ex){
            throw new entradaInvalidaException(""+ex);
        }
    }
    
    public boolean atualizaPrefeito() throws entradaInvalidaException {
        conexaoBD conexao = new conexaoBD();
        
        try{
            conexao.atualizarCandidato(this);
            return true;
        }
        catch(Exception ex){
            throw new entradaInvalidaException(""+ex);
        }
       
    }
    
}
