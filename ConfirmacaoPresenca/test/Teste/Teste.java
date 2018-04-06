/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import dao.RespostaDao;
import modelo.Resposta;

/**
 *
 * @author Jônatas e Wesley
 */
public class Teste {
    public static void main(String[] args) {
        Resposta r = new Resposta();
        
       RespostaDao dao = new RespostaDao();
       
       for(int i =900;i>800;i--){
       
       r.setNome( "resposta n"+i);
       r.setCpf("999."+i+".999-99");
       r.setTelefone("4545454545");
       r.setPresenca(0);
       r.setSenha("1");
      dao.inserir(r);
       
       
       
       }
       
        
        
    }
}
