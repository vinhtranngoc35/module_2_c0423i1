package service;


import java.util.List;


public interface BaseCRUDService<T>{
    void create(T t);
    void update(T t);
    List<T> findAll();
    void delete(T t);
}
