package ee.itcollege.bot.dao;

import java.util.List;


public interface AbstractDao<T> {

    List<T> getAll();
    
    T persist(T item);
    
    T update(T item);
    
    T findById(Long id);
    
    void delete(T item);
    
}
