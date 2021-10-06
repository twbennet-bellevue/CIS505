package Module_6;

import java.util.List;

public interface GenericDao<E,K> {
    
    List<E> findAll();
    E findBy(K key);
    void insert(E entity);

}
