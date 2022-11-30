package br.univille.poo.app.ui.cadastroDeTarefas;

import br.univille.poo.app.ui.listaDeTarefa.ListaDeTarefasModel;
import br.univille.poo.app.servico.TarefaDeleteService;
import br.univille.poo.app.ui.listaDeTarefa.ListaDeTarefasController;
import br.univille.poo.app.servico.ListarTarefas;
import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.servico.TarefaConcluirService;
import br.univille.poo.app.ui.listaDeTarefa.ListaDeTarefasView;

public class CadastroDeTarefasController implements CadastroDeTarefasView.ViewListenerCadastroTarefas {

    private CadastroDeTarefasView view;
    private CadastroDeTarefasModel model;

    private boolean editar;
    private String id;

    
    public void editar(String id) throws Exception {
        this.editar = true;
        Tarefa tarefa = model.getById(id);
        view.tarefaTextArea.setText(tarefa.getDescricao());
        view.opcoesComboBox.setSelectedItem(tarefa.getPrioridade());
        view.finalizadoCheck.setSelected(tarefa.isConcluido());
    }

    public CadastroDeTarefasController(CadastroDeTarefasModel model, CadastroDeTarefasView view){
        this.view = view;
        this.model = model;
        this.view.addListener(this);
    }

    public void MostraView(){
        view.setVisible(true);
    }



    @Override
    public void onSalvar(String tarefaText, String opcaoCombo, boolean checkText) throws Exception {
        Tarefa tarefaC = new Tarefa();
        tarefaC.setDescricao(tarefaText);
        tarefaC.setConcluido(checkText);
        tarefaC.setPrioridade(opcaoCombo);

        if(editar){
            model.atualizarTarefa(this.id, tarefaC);
        }else{
            model.adicionarTarefa(tarefaC);
        }
        this.openLista();
    }

    @Override
    public void onExcluir(String id) throws Exception {

    }
    
    public void openLista(){
        view.setVisible(false);
        ListaDeTarefasModel model = new ListaDeTarefasModel(new ListarTarefas(), new TarefaConcluirService(), new TarefaDeleteService());
        ListaDeTarefasView view = new ListaDeTarefasView();
        ListaDeTarefasController control = new ListaDeTarefasController(view, model);
        control.MostraView();
    }

    @Override
    public void onCancelar() throws Exception {
        this.openLista();
    }

}
