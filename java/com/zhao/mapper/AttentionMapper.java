package com.zhao.mapper;

import com.zhao.pojo.Attention;

import java.util.Date;
import java.util.List;

public interface AttentionMapper {
    void add(String content, Date date);
    void delete(String content);
    void deleteByDate(Date date);
    void update(Attention attention);
    Attention getOne(String content);
    List<Attention> listAll();

}
