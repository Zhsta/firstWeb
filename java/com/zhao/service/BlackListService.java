package com.zhao.service;

import com.zhao.mapper.BlackListMapper;
import com.zhao.pojo.BlackList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class BlackListService {
    @Autowired
    private BlackListMapper blackListMapper;
    public BlackList get(String username){
        return blackListMapper.get(username);
    }
    public void delete(String username){
        blackListMapper.delete(username);
    }
    public void add(BlackList blackList){
        blackListMapper.add(blackList);
    }
    public void update(BlackList blackList){
        blackListMapper.update(blackList);
    }
}
