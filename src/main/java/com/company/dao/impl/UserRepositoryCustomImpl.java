/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.Authority;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author FX506ICB
 */


//Data Access Object
@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    EntityManager em;
    private static BCrypt.Hasher crypt = BCrypt.withDefaults();
   /* private User getUser(ResultSet rs) throws Exception {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String profileDesc = rs.getString("profile_description");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String address = rs.getString("address");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");
        String password = rs.getString("password");
        //int userId=rs.getInt("user_id");
        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);

        //return new User(id, name, surname, profileDesc, phone, email, address, birthdate, nationality, birthplace, password);
        return null;
    }*/


    /*@Override
    public User findByEmailAndPassword(String email, String password) {
        User result = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT *from user where email =? and password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result = getUserSimple(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }*/

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityIdByRequest) {

        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname";
        }
        if (nationalityIdByRequest != null) {
            jpql += " and u.nationality.id=:nid";
        }

        Query q = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }
        if (nationalityIdByRequest != null) {
            q.setParameter("nid", nationalityIdByRequest);
        }

        return q.getResultList();
    }

    @Override
    public User findByEmail(String email) {
        Query query = em.createNativeQuery("select *from user where email=?", User.class);
        query.setParameter(1, email);
        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
    @Override
    public List<Authority>  authorities(Integer id) {
        Query query = em.createNativeQuery("SELECT  authority.id,authority.name from authority INNER JOIN authority_user ON " +
                "authority_user.user_id =? and  authority_user.authority_id = authority.id", Authority.class);
        query.setParameter(1,id);
        return  query.getResultList();
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    @Override
    public User getById(int userId) {
        User u = em.find(User.class, userId);
        return u;
    }

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        em.persist(u);
        return true;
    }
}