package com.zhao.mapper;

import com.zhao.pojo.BlackList;

public interface BlackListMapper {
    BlackList get(String username);
    void delete(String username);
    void add(BlackList blackList);
    void update(BlackList blackList);
}
