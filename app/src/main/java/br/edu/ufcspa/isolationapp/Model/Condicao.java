package br.edu.ufcspa.isolationapp.Model;

/**
 * Created by icaromsc on 10/06/2017.
 */

public class Condicao {
    private int id;
    private String nomeCondicao;
    private String tipo;
    private String duracao;
    private String info;

    public Condicao(int id, String nomeCondicao, String tipo, String duracao, String info) {
        this.id = id;
        this.nomeCondicao = nomeCondicao;
        this.tipo = tipo;
        this.duracao = duracao;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCondicao() {
        return nomeCondicao;
    }

    public void setNomeCondicao(String nomeCondicao) {
        this.nomeCondicao = nomeCondicao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return "Condicao{" +
                "id=" + id +
                ", nomeCondicao='" + nomeCondicao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", duracao='" + duracao + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
