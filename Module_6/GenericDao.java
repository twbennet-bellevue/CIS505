/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_6;

import java.util.List;

/**
 * Interface Generic Dao
 */
public interface GenericDao<E,K> {
    
    public List<E> findAll();
    public E findBy(K key);
    public void insert(E entity);

}
