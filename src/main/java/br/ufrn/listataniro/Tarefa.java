package br.ufrn.listataniro;

import java.util.Date;

public class Tarefa {
    private Integer id;
    private String texto;
    private final Date dataCadastro;
    private Integer prioridade;

    public Tarefa(String texto, Integer prioridade){
        this.texto = texto;
        this.prioridade = prioridade;
        this.dataCadastro = new Date();
    }

    public Tarefa(Integer id, String texto, Date dataCadastro, Integer prioridade) {
        this.id = id;
        this.texto = texto;
        this.dataCadastro = dataCadastro;
        this.prioridade = prioridade;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTexto() {
        return texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public Date getDataCadastro() {
        return dataCadastro;
    }
    
    public Integer getPrioridade() {
        return prioridade;
    }
    
    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }
}
