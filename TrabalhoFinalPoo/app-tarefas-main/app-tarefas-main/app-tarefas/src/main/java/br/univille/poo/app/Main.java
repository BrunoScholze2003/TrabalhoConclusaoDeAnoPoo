package br.univille.poo.app;

import br.univille.poo.app.ui.listaDeTarefa.ListaDeTarefasView;
import br.univille.poo.app.ui.listaDeTarefa.ListaDeTarefasController;
import br.univille.poo.app.servico.ListarTarefas;
import br.univille.poo.app.servico.TarefaDeleteService;
import br.univille.poo.app.persistencia.CriarTabelas;
import br.univille.poo.app.servico.TarefaConcluirService;
import br.univille.poo.app.ui.listaDeTarefa.ListaDeTarefasModel;

public class Main {

    public static void main(String[] args) {
        CriarTabelas.criarTabelas();

        ListaDeTarefasModel model = new ListaDeTarefasModel(new ListarTarefas(), new TarefaConcluirService(), new TarefaDeleteService());
        ListaDeTarefasView view = new ListaDeTarefasView();
        ListaDeTarefasController control = new ListaDeTarefasController(view, model);
        control.MostraView();
    }

}
