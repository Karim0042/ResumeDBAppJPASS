/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @author FX506ICB
 */


//Data Acces Object
@Repository
@Transactional
public class EmploymentHistoryServiceImpl extends AbstractDAO implements EmploymentHistoryServiceInter {

    @Autowired
    EmploymentHistoryDaoInter employmentHistoryDaoInter;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        return employmentHistoryDaoInter.getAllEmploymentHistoryByUserId(userId);
    }

    @Override
    public boolean addEmpHistory(EmploymentHistory emp) {
        employmentHistoryDaoInter.addEmpHistory(emp);
        return true;
    }
    @Override
    public boolean updateEmpHistory(EmploymentHistory emp) {
        return employmentHistoryDaoInter.updateEmpHistory(emp);
    }
}