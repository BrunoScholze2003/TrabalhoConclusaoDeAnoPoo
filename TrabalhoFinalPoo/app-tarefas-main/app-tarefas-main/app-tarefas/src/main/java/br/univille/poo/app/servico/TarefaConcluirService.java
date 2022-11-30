package br.univille.poo.app.servico;

import br.univille.poo.app.persistencia.TarefaDAO;

public class TarefaConcluirService {
    private TarefaDAO dao;

    public TarefaConcluirService(){
        dao = new TarefaDAO();
    }

    public void concluir(String id, boolean atual){
        dao.concluir(id,atual);
    }
}
