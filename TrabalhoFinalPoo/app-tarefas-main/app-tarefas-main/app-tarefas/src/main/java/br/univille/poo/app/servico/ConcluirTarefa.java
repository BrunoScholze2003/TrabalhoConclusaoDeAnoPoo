package br.univille.poo.app.servico;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.TarefaDAO;

public class ConcluirTarefa {


    private TarefaDAO dao;

    public ConcluirTarefa(){
        dao = new TarefaDAO();
    }

    public void concluir(Tarefa tarefa) throws Exception {
        if(tarefa.getId() < 1){
            throw  new Exception("Id invalido da tarefa.");
        }
        if(tarefa.isConcluido()){
            throw  new Exception("Tarefa "+tarefa.getId()+" foi concluída.");
        }
        tarefa.setConcluido(true);
    }

}
