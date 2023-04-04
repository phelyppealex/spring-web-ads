package br.ufrn.listataniro;

import java.util.Date;

public class Tarefa {
    private Integer id;
    private String texto;
    private final Date dataCadastro;
    private Integer prioridade;
    
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
