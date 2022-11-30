package br.univille.poo.app.servico;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.TarefaDAO;

public class TarefaDeleteService {
    private TarefaDAO dao;

    public TarefaDeleteService(){
        dao = new TarefaDAO();
    }

    public void delete(String id){
        dao.excluir(id);
    }
}
