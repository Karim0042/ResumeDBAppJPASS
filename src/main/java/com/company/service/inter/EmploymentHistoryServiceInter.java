/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.inter;

/**
 *
 * @author FX506ICB
 */

import com.company.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryServiceInter {

    public List<EmploymentHistory>getAllEmploymentHistoryByUserId(int userId);
    public boolean addEmpHistory(EmploymentHistory emp);
    public boolean updateEmpHistory(EmploymentHistory emp);


}