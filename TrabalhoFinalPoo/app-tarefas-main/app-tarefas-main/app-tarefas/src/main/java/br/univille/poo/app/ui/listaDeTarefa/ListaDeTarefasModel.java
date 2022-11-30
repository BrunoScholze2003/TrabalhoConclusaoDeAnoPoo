package br.univille.poo.app.ui.listaDeTarefa;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.servico.ListarTarefas;
import br.univille.poo.app.servico.TarefaConcluirService;
import br.univille.poo.app.servico.TarefaDeleteService;


public class ListaDeTarefasModel {
    private final TarefaDeleteService tarefaDeleteService;
    private final TarefaConcluirService tarefaConcluirService;
    private Tarefa tarefa;
    private ListarTarefas listarTarefas;

    public ListaDeTarefasModel(ListarTarefas listarTarefas, TarefaConcluirService tarefaConcluirService, TarefaDeleteService tarefaDeleteService){
        this.listarTarefas = listarTarefas;
        this.tarefaConcluirService = tarefaConcluirService;
        this.tarefaDeleteService = tarefaDeleteService;
    }

    public void excluirTarefa(String id) throws Exception {
        this.tarefaDeleteService.delete(id);
    }

    public void concluirTarefa(String id, boolean estado) throws Exception {
        this.tarefaConcluirService.concluir(id,estado);
    }
}
