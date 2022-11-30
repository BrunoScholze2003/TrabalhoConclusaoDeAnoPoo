package br.univille.poo.app.ui.listaDeTarefa;

import br.univille.poo.app.ui.cadastroDeTarefas.CadastroDeTarefasView;
import br.univille.poo.app.servico.*;
import br.univille.poo.app.ui.cadastroDeTarefas.CadastroDeTarefasModel;
import br.univille.poo.app.ui.cadastroDeTarefas.CadastroDeTarefasController;

public class ListaDeTarefasController implements ListaDeTarefasView.ListaDeTarefasViewListener {

    private ListaDeTarefasView view;
    private ListaDeTarefasModel model;

    public ListaDeTarefasController(ListaDeTarefasView view, ListaDeTarefasModel model){
        this.view = view;
        this.model = model;
        this.view.addListener(this);
    }

    public void MostraView(){
        view.setVisible(true);
    }

    @Override
    public void onAdicionar() {
        view.setVisible(false);
        CadastroDeTarefasModel modelTarefas = new CadastroDeTarefasModel(new CriarTarefa(), new TarefaGetByIdService());
        CadastroDeTarefasView viewTarefas = new CadastroDeTarefasView();
        CadastroDeTarefasController controlTarefas = new CadastroDeTarefasController(modelTarefas,viewTarefas);
        controlTarefas.MostraView();
    }

    @Override
    public void onConcluir(String id, boolean atual) throws Exception {
        model.concluirTarefa(id, atual);
    }

    @Override
    public void onExcluir(String id) throws Exception {
        model.excluirTarefa(id);
        view.setVisible(false);
        ListaDeTarefasModel model = new ListaDeTarefasModel(new ListarTarefas(), new TarefaConcluirService(), new TarefaDeleteService());
        ListaDeTarefasView view = new ListaDeTarefasView();
        ListaDeTarefasController control = new ListaDeTarefasController(view, model);
        control.MostraView();
    }

    @Override
    public void onEditar(String id) throws Exception {
        view.setVisible(false);
        CadastroDeTarefasModel modelTarefas = new CadastroDeTarefasModel(new CriarTarefa(), new TarefaGetByIdService());
        CadastroDeTarefasView viewTarefas = new CadastroDeTarefasView();
        CadastroDeTarefasController controlTarefas = new CadastroDeTarefasController(modelTarefas,viewTarefas);
        controlTarefas.editar(id);
        controlTarefas.MostraView();
    }
}
