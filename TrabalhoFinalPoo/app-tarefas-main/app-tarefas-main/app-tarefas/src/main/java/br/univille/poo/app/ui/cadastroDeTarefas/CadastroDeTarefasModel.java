package br.univille.poo.app.ui.cadastroDeTarefas;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.servico.CriarTarefa;
import br.univille.poo.app.servico.TarefaGetByIdService;

public class CadastroDeTarefasModel {


    private Tarefa tarefa;
    private CriarTarefa createService;

    private TarefaGetByIdService tarefaGetByIdService;

    public CadastroDeTarefasModel(CriarTarefa createService, TarefaGetByIdService tarefaGetByIdService){
        this.createService = createService;
        this.tarefaGetByIdService = tarefaGetByIdService;
    }

    public Tarefa getById(String id) throws Exception {
        return this.tarefaGetByIdService.getById(id);
    }
    public void adicionarTarefa(Tarefa tarefa) throws Exception {
        this.createService.criar(tarefa);
    }
    public void atualizarTarefa(String id, Tarefa tarefa) throws Exception {
        this.createService.criar(tarefa);
    }

}
