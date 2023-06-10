/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.inter;

import com.company.entity.Skill;

import java.util.List;

/**
 *
 * @author FX506ICB
 */
public interface SkillDaoInter {
    
public List<Skill> getAllSkill(); 
 
public Skill getSkillById(int id);

public boolean updateSkill(Skill s);

public boolean removeSkill(int id);

public boolean addSkill(Skill s);

}