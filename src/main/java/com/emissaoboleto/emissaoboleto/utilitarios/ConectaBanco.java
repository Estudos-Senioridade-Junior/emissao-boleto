package com.emissaoboleto.emissaoboleto.utilitarios;


import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

@Service
public class ConectaBanco {

    private final String caminho="jdbc:mysql://localhost:3306/banco_testes";
    private final String user="root";
    private final String pass="pA18082008@";
    private Statement stm;
    public ResultSet rs;
    private final String driver = "com.mysql.jdbc.Driver";
    public Connection conn;

    private Logger logger;
    public ConectaBanco (){

    }


    public void conexao(){
        
        try {
            try {
                try {
                    Class.forName(driver).newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(com.emissaoboleto.emissaoboleto.utilitarios.ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(com.emissaoboleto.emissaoboleto.utilitarios.ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Erro, motivo: \n"+ex);
            }
            conn=DriverManager.getConnection(caminho, user, pass);
           System.out.println("conectado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexao/n"+ex);
        }
    }
    
    public void executaSQL(String sql){
        try {
            stm=conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
           int rs= stm.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Execucao SQL! \n"+ex.getMessage());
        }
    }
    
    public void executaPesquisaSQL(String sql){
        try {
            stm=conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
           rs= stm.executeQuery(sql);
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Execucao SQL! \n"+ex.getMessage());
        }
    }
    public void desconecta(){
        try{
            conn.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexao");            
        }
    }
}
