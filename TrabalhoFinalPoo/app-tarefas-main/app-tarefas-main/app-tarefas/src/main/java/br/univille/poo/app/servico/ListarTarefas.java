package br.univille.poo.app.servico;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.TarefaDAO;

import java.util.List;

public class ListarTarefas {

    private TarefaDAO dao;

    public ListarTarefas(){
        dao = new TarefaDAO();
    }

    public List<Tarefa> obterTodos(){
        return dao.obterTodos();
    }

    public void excluir(String id){
        dao.excluir(id);
    }

}
