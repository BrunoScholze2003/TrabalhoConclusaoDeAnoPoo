package br.univille.poo.app.servico;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.TarefaDAO;


public class TarefaGetByIdService {


    private TarefaDAO dao;

    public TarefaGetByIdService(){
        dao = new TarefaDAO();
    }

    public Tarefa getById(String id){
        return dao.getById(id);
    }
}
