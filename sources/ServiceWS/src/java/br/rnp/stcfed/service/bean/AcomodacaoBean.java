/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.rnp.stcfed.service.bean;

import java.io.Serializable;

/**
 *
 * @author Andre Luiz
 */
public class AcomodacaoBean implements Serializable{

      private int idAcomodacao;
      private String nmAcomodacao;
      private String descricao;
      private String lvSacada;
      private String lvCozinha;
      private String lvHidro;
      private String lvKitpraia;
      private String lvTv;
      private String lvCafe;
      private String lvSauna;
      private String lvArcondicionado;

    public AcomodacaoBean(int idAcomodacao, String nmAcomodacao, String descricao, String lvSacada, String lvCozinha, String lvHidro, String lvKitpraia, String lvTv, String lvCafe, String lvSauna, String lvArcondicionado) {
        this.idAcomodacao = idAcomodacao;
        this.nmAcomodacao = nmAcomodacao;
        this.descricao = descricao;
        this.lvSacada = lvSacada;
        this.lvCozinha = lvCozinha;
        this.lvHidro = lvHidro;
        this.lvKitpraia = lvKitpraia;
        this.lvTv = lvTv;
        this.lvCafe = lvCafe;
        this.lvSauna = lvSauna;
        this.lvArcondicionado = lvArcondicionado;
    }

    public AcomodacaoBean() {
    }

    



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdAcomodacao() {
        return idAcomodacao;
    }

    public void setIdAcomodacao(int idAcomodacao) {
        this.idAcomodacao = idAcomodacao;
    }

    public String getLvArcondicionado() {
        return lvArcondicionado;
    }

    public void setLvArcondicionado(String lvArcondicionado) {
        this.lvArcondicionado = lvArcondicionado;
    }

    public String getLvCafe() {
        return lvCafe;
    }

    public void setLvCafe(String lvCafe) {
        this.lvCafe = lvCafe;
    }

    public String getLvCozinha() {
        return lvCozinha;
    }

    public void setLvCozinha(String lvCozinha) {
        this.lvCozinha = lvCozinha;
    }

    public String getLvHidro() {
        return lvHidro;
    }

    public void setLvHidro(String lvHidro) {
        this.lvHidro = lvHidro;
    }

    public String getLvKitpraia() {
        return lvKitpraia;
    }

    public void setLvKitpraia(String lvKitpraia) {
        this.lvKitpraia = lvKitpraia;
    }

    public String getLvSacada() {
        return lvSacada;
    }

    public void setLvSacada(String lvSacada) {
        this.lvSacada = lvSacada;
    }

    public String getLvSauna() {
        return lvSauna;
    }

    public void setLvSauna(String lvSauna) {
        this.lvSauna = lvSauna;
    }

    public String getLvTv() {
        return lvTv;
    }

    public void setLvTv(String lvTv) {
        this.lvTv = lvTv;
    }

    public String getNmAcomodacao() {
        return nmAcomodacao;
    }

    public void setNmAcomodacao(String nmAcomodacao) {
        this.nmAcomodacao = nmAcomodacao;
    }

}
