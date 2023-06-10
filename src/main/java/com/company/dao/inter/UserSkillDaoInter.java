/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

/**
 *
 * @author FX506ICB
 */
import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {

public List<UserSkill>getAllSkillByUserId(int userId);

public boolean insertUserSkill(UserSkill u);

public boolean removeUserSkill(int id);

public boolean updateUserSkill(UserSkill u);

}