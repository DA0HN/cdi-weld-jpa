package br.com.gabriel.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
public abstract class BaseRepository<T> implements Repository<T> {

  private final EntityManager manager;
  private final Class<T> entityClass;

  public BaseRepository(
    EntityManager manager,
    Class<T> entityClass
  ) {
    this.manager = manager;
    this.entityClass = entityClass;
  }

  public abstract String getTableName();

  @Override public T findById(UUID id) {
    return manager.find(entityClass, id);
  }

  @Override public List<T> findAll() {
    var selectQuery = "SELECT user FROM table user";
    var query = selectQuery.replace("table", getTableName());
    return manager.createQuery(query, entityClass).getResultList();
  }

  @SafeVarargs
  @Override public final void update(UUID id, Consumer<T>... updates) throws Exception {
    beginTransaction();
    T entity = this.findById(id);
    Arrays.stream(updates).forEach(action -> action.accept(entity));
    commitTransaction();
  }

  @Override public void save(T entity) {
    beginTransaction();
    manager.persist(entity);
    commitTransaction();
  }

  @Override public void remove(UUID id) {
    T entity = findById(id);
    beginTransaction();
    manager.remove(entity);
    commitTransaction();
  }

  @Override public List<T> findByName(String name) {
    var selectQuery = "SELECT user FROM table user WHERE upper(user.name) LIKE :name";
    var formattedQuery = selectQuery.replace("table", getTableName());
    var query = manager.createQuery(formattedQuery, entityClass);
    query.setParameter("name","%" + name.trim().toUpperCase() + "%");
    return query.getResultList();
  }

  private void beginTransaction() {
    try {
      manager.getTransaction().begin();
    }
    catch(IllegalStateException exception) {
      rollBackTransaction();
    }
  }

  private void commitTransaction() {
    try {
      manager.getTransaction().commit();
    }
    catch(IllegalStateException | RollbackException exception) {
      rollBackTransaction();
    }
  }

  private void rollBackTransaction() {
    try {
      manager.getTransaction().rollback();
    }
    catch(IllegalStateException | PersistenceException exception) {
      exception.printStackTrace();
    }
  }
}
