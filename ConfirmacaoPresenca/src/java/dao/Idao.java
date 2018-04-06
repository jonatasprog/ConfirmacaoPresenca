/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Resposta;

/**
 *
 * @author Jônatas e Wesley
 */
public interface Idao {

    public boolean inserir(Resposta res);

    public boolean excluir(Resposta res);

    public boolean alterar(Resposta res);

    public Object buscarId(int id);

    public Object buscarTodos();

}
