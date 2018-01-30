/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rnp.stcfed.service.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author ANDRE
 */
public class ReservaBean implements Serializable{

    private int idReserva;
    private String nome;
    private String telefone;
    private String email;
    private int nrPessoas;
    private String dtEntrada;
    private String dtSaida;
    private String obs;
    private String crianca;
    private AcomodacaoBean acomodacao;

    public ReservaBean() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(String dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public String getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(String dtSaida) {
        this.dtSaida = dtSaida;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNrPessoas() {
        return nrPessoas;
    }

    public void setNrPessoas(int nrPessoas) {
        this.nrPessoas = nrPessoas;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCrianca() {
        return crianca;
    }

    public void setCrianca(String crianca) {
        this.crianca = crianca;
    }

    public AcomodacaoBean getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(AcomodacaoBean acomodacao) {
        this.acomodacao = acomodacao;
    }

}
