package br.edu.ufcspa.isolationapp.Model;

/**
 * Created by icaromsc on 10/06/2017.
 */

public class Epi {
    private int id;
    private String nome;
    private String tipo;
    private String descricao;
    private String observacoes;

    public Epi(int id, String nome, String tipo, String descricao, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Epi{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
