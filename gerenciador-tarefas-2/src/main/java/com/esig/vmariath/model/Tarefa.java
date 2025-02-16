package com.esig.vmariath.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String responsavel;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Temporal(TemporalType.DATE)
    private Date prazo;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    // Construtores
    public Tarefa() {
        this.situacao = Situacao.EM_ANDAMENTO; // Situação padrão ao criar uma tarefa
    }

    public Tarefa(String titulo, String descricao, String responsavel, Prioridade prioridade, Date prazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.prioridade = prioridade;
        this.prazo = prazo;
        this.situacao = Situacao.EM_ANDAMENTO; // Situação padrão ao criar uma tarefa
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    // Enum para Prioridade
    public enum Prioridade {
        ALTA,
        MEDIA,
        BAIXA
    }

    // Enum para Situação
    public enum Situacao {
        EM_ANDAMENTO,
        CONCLUIDA
    }
}