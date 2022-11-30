package br.univille.poo.app.servico;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.TarefaDAO;

public class TarefaUpdateService {
    private TarefaDAO dao;

    public TarefaUpdateService(){
        dao = new TarefaDAO();
    }

    public void update(String id, Tarefa tarefa){
        dao.atualizar(id, tarefa);
    }
}
