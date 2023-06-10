/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.inter;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author FX506ICB
 */


public abstract class AbstractDAO {

    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
      //  com.mysql.cj.jdbc.Driver driver;
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "root123";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

    private EntityManagerFactory emFactory = null;

    public EntityManager em() {
        if(emFactory==null){
         emFactory = Persistence.createEntityManagerFactory("resumeJPA");
        }
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    public void close(EntityManager em){
        em.close();
        emFactory.close();
    }
}
