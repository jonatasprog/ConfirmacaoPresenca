/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Resposta;

/**
 *
 * @author Jônatas e Wesley
 */
public class RespostaDao {

    private String CMD;
    private Connection con;
    private PreparedStatement ps;

    public boolean inserir(Resposta res) {
        boolean sucesso = false;

        CMD = "INSERT INTO Respostas(cpf,email,nome,senha,telefone,presenca) values(?,?,?,?,?,?);";

        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(CMD);
            ps.setString(1, res.getCpf());
            ps.setString(2, res.getEmail());
            ps.setString(3, res.getNome());
            ps.setString(4, res.getSenha());
            ps.setString(5, res.getTelefone());
            ps.setInt(6, res.getPresenca());
            if (ps.executeUpdate() > 0) {
                System.out.println("Cadastrado com sucesso");
                sucesso = true;
            }
            con.commit();
            ps.close();
            con.close();

        } catch (Exception ex) {
            try {
                System.out.print("Os dados nao foram gravados");
                con.rollback();
            } catch (Exception ex2) {
            }
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception ex3) {
            }
        }
        return sucesso;

        //
    }

    public boolean excluir(Resposta res) {
        boolean sucesso = false;
        CMD = "DELETE FROM Respostas WHERE id =?;";

        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(CMD);
            ps.setInt(1, res.getId());

            if (ps.executeUpdate() > 0) {
                sucesso = true;
                System.out.println(" Removido com sucesso.");
            } else {
                System.out.println("O ID informado nao existe");
            }
            con.commit();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.print("nao foi removido");
        }

        return sucesso;
    }

    public boolean alterar(Resposta res) {
        boolean sucesso = false;
        CMD = "UPDATE Respostas SET cpf=?,email=?,nome=?,senha=?,telefone=?,presenca=? WHERE id =?";

        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(CMD);
            ps.setString(1, res.getCpf());
            ps.setString(2, res.getEmail());
            ps.setString(3, res.getNome());
            ps.setString(4, res.getSenha());
            ps.setString(5, res.getTelefone());
            ps.setInt(6, res.getPresenca());
            ps.setInt(7, res.getId());
            if (ps.executeUpdate() > 0) {
                sucesso = true;
                System.out.println(" alterado com sucesso");
            }
            con.commit();
            ps.close();
            con.close();

        } catch (Exception ex) {
            try {
                System.out.print("Os dados nao foram gravados");
                con.rollback();
            } catch (Exception ex2) {
            }
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex3) {
            }
        }

        return sucesso;
    }

    public Object buscarId(int id) {
        Resposta r = new Resposta();
        CMD = "SELECT cpf,email,nome,senha,telefone,presenca FROM Respostas WHERE id =?";

        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(CMD);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r.setCpf(rs.getString(1));
                r.setEmail(rs.getString(2));
                r.setNome(rs.getString(3));
                r.setSenha(rs.getString(4));
                r.setTelefone(rs.getString(5));
                r.setPresenca(rs.getInt(6));
                r.setId(id);
                con.commit();
                ps.close();
                con.close();
                return r;
            }

        } catch (SQLException ex) {
            System.out.print("Não foi possivel localizar");
        }
        return null;

    }

    public List buscarConfirmados() {

        List lista = new ArrayList();

        CMD = "SELECT id,cpf,email,nome,senha,telefone,presenca FROM Respostas WHERE presenca =1;";
        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(CMD);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Resposta r = new Resposta();
                r.setId(rs.getInt(1));
                r.setCpf(rs.getString(2));
                r.setEmail(rs.getString(3));
                r.setNome(rs.getString(4));
                r.setSenha(rs.getString(5));
                r.setTelefone(rs.getString(6));
                r.setPresenca(rs.getInt(7));
                lista.add(r);
            }

            con.commit();
            ps.close();
            con.close();
            return lista;

        } catch (SQLException ex) {
            System.out.println(" Aconteceu um erro! Não foi possivel encontrar nada");

            return null;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {

            }
        }

    }

    public List buscarNaoConfirmados() {

        List lista = new ArrayList();

        CMD = "SELECT id,cpf,email,nome,senha,telefone,presenca FROM Respostas WHERE presenca !=1;";
        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(CMD);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Resposta r = new Resposta();
                r.setId(rs.getInt(1));
                r.setCpf(rs.getString(2));
                r.setEmail(rs.getString(3));
                r.setNome(rs.getString(4));
                r.setSenha(rs.getString(5));
                r.setTelefone(rs.getString(6));
                r.setPresenca(rs.getInt(7));
                lista.add(r);
            }

            con.commit();
            ps.close();
            con.close();
            return lista;

        } catch (SQLException ex) {
            System.out.println(" Aconteceu um erro! Não foi possivel encontrar nada");

            return null;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {

            }
        }

    }

    public List buscarTodos() {

        List lista = new ArrayList();

        CMD = "SELECT id,cpf,email,nome,senha,telefone,presenca FROM Respostas;";
        Connection con = null;
        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(CMD);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Resposta r = new Resposta();
                r.setId(rs.getInt(1));
                r.setCpf(rs.getString(2));
                r.setEmail(rs.getString(3));
                r.setNome(rs.getString(4));
                r.setSenha(rs.getString(5));
                r.setTelefone(rs.getString(6));
                r.setPresenca(rs.getInt(7));
                lista.add(r);
            }

            con.commit();
            ps.close();
            con.close();
            return lista;

        } catch (SQLException ex) {
            System.out.println(" Aconteceu um erro! Não foi possivel encontrar nada");

            return null;
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {

            }
        }

    }
    
   //
    public Object buscarCpf(String cpf) {
        Resposta r = new Resposta();
        CMD = "SELECT id,email,nome,senha,telefone,presenca FROM Respostas WHERE cpf =?;";
        
        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(CMD);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r.setCpf(rs.getString(1));
                r.setEmail(rs.getString(2));
                r.setNome(rs.getString(3));
                r.setSenha(rs.getString(4));
                r.setTelefone(rs.getString(5));
                r.setPresenca(rs.getInt(6));
                r.setCpf(cpf);
                con.commit();
                ps.close();
                con.close();
                return r;
            }

        } catch (SQLException ex) {
            System.out.print("Não foi possivel localizar");
        }
        return null;

    }



}
