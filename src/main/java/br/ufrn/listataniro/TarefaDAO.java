package br.ufrn.listataniro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TarefaDAO {
    private final String sel_all = "SELECT * FROM tarefa";
    private final String insert = "INSERT INTO tarefa (texto,prioridade,dataCadastro) VALUES (?,?,?)";
    private Conexao c;

    public TarefaDAO(){
        c = new Conexao();
    }

    public ArrayList<Tarefa> listar(){
        Tarefa t;
        ArrayList<Tarefa> tarefa = new ArrayList<Tarefa>();

        try{
            c.conectar();

            Statement statement = c.getConexao().createStatement();
            ResultSet rs = statement.executeQuery(sel_all);

            while(rs.next()){
                t = new Tarefa(
                    rs.getInt("id"),
                    rs.getString("texto"),
                    rs.getDate("dataCadastro"),
                    rs.getInt("prioridade")
                );

                tarefa.add(t);
            }

            c.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao listar - " + e.getMessage());
        }
        return tarefa;
    }

    public void inserir(Tarefa t){
        try{
            c.conectar();

            PreparedStatement statement = c.getConexao().prepareStatement(insert);
            statement.setString(1, t.getTexto());
            statement.setInt(2, t.getPrioridade());
            //Conversão da data do Java em data do SQL
            java.sql.Date dataCadastro = new java.sql.Date(t.getDataCadastro().getTime());
            statement.setDate(3, dataCadastro);
            statement.execute();

            c.desconectar();
        }catch(Exception e){
            System.out.println("Erro ao inserir - " + e.getMessage());
        }
    }
}
