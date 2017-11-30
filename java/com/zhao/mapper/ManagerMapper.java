package com.zhao.mapper;
import com.zhao.pojo.*;
public interface ManagerMapper {
    void add(Manager manager);
    Integer getId(String username);
    Manager get (String username);
    void delete(String username);
    void update(Manager manager);
}
