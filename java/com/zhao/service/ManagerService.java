package com.zhao.service;


import com.zhao.mapper.ManagerMapper;
import com.zhao.pojo.Manager;
import com.zhao.util.CheckNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    public void add(Manager manager){
        managerMapper.add(manager);
    }
    public int getId(String username){
        return CheckNull.returnHandler(managerMapper.getId(username));
    }
    public Manager get (String username){
        return managerMapper.get(username);
    }
    public void delete(String username){
        managerMapper.delete(username);
    }
    public void update(Manager manager){
        managerMapper.update(manager);
    }

    public boolean isRegist(String username,String password){
        Manager manager=managerMapper.get(username);
        if(manager==null){
            return false;
        }
        if(password.equals(manager.getPassword())){
            return true;
        }
        else
            return false;
    }


}
