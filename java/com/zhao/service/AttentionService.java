package com.zhao.service;

import com.zhao.mapper.AttentionMapper;
import com.zhao.pojo.Attention;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AttentionService {
    @Autowired
    private AttentionMapper attentionMapper;
    public void add(String content, Date date){
        attentionMapper.add(content,date);
    }
    public void delete(String content){
        attentionMapper.delete(content);
    }
    public void deleteByDate(Date date){
        attentionMapper.deleteByDate(date);
    }
    public void update(Attention attention){
        attentionMapper.update(attention);
    }
    public Attention getOne(String content){
        return attentionMapper.getOne(content);
    }
    public List<Attention> listAll(){
        return attentionMapper.listAll();
    }
}
