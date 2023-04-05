package br.ufrn.listataniro;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String caminho;
    private String usuario;
    private String senha;
    private Connection minhaConexao;

    public Conexao(){
        this.caminho = "jdbc:postgresql://localhost:5432/spring_learn";
        this.usuario = "postgres";
        this.senha = "1234";
    }

    public void conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            minhaConexao = DriverManager.getConnection(caminho, usuario, senha);
        }catch(Exception e){
            System.out.println("Erro ao abrir conexão - " + e.getMessage());
        }
    }

    public void desconectar(){
        try{
            minhaConexao.close();
        }catch(Exception e){
            System.out.println("Erro ao fechar conexão - " + e.getMessage());
        }
    }

    public Connection getConexao(){
        return minhaConexao;
    }
}
