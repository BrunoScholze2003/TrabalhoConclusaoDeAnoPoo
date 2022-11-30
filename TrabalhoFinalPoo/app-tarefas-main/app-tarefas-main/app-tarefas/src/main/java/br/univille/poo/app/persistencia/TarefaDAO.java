package br.univille.poo.app.persistencia;

import br.univille.poo.app.entidade.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class TarefaDAO extends BaseDAO{

    public void inserir(Tarefa tarefa) {
        String sql = "insert into tarefa(descricao, concluido, prioridade) values(? ,?, ?)";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,tarefa.getDescricao());
            p.setBoolean(2,tarefa.isConcluido());
            p.setString(3,tarefa.getPrioridade());
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }
    }

    public void excluir(String id) {
        String sql = "delete from tarefa where id=?";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,id);
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao excluir tarefa ");
            e.printStackTrace();
        }
    }

    public void atualizar(String id,Tarefa tarefa) {
        String sql = "update  tarefa set concluido = ?, descricao = ? where id =  ?";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setBoolean(1,tarefa.isConcluido());
            p.setString(2,tarefa.getDescricao());
            p.setString(3,id);
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao atualizar tarefa ");
            e.printStackTrace();
        }
    }

    public List<Tarefa> obterTodos() {
        List<Tarefa> lista = new ArrayList<>();
        String sql = "select id, descricao, concluido, prioridade from tarefa";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){

            ResultSet resultSet = p.executeQuery();
            while(resultSet.next()){
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setConcluido(resultSet.getBoolean("concluido"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setPrioridade(resultSet.getString("prioridade"));

                lista.add(tarefa);
            }
        }catch (SQLException e){
            System.out.println("Erro ao obter todas as tarefas ");
            e.printStackTrace();
        }
        return lista;
    }

    public Tarefa getById(String id) {
        String sql = "select id, descricao, concluido, prioridade from tarefa where id=?";
        Tarefa tarefa = new Tarefa();
        try (Connection c = obterConexao();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, id);
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setConcluido(resultSet.getBoolean("concluido"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setPrioridade(resultSet.getString("prioridade"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter tarefas ");
            e.printStackTrace();
        }
        return tarefa;
    }

    public void concluir(String id, boolean atual) {
        boolean concluido = atual == true ? false : true;
        String sql = "update tarefa set concluido = ? where id = ?";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setBoolean(1,concluido);
            p.setString(2,id);
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao concluir tarefa ");
            e.printStackTrace();
        }
    }


}