package br.univille.poo.app.persistencia;

import java.sql.Connection;

class BaseDAO {

    protected Connection obterConexao(){
        return FabricaDeConexoes.obterInstancia().obterConexao();
    }

}
