package br.com.gabriel.repositories;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
public interface Repository<T> {

  T findById(UUID id);
  List<T> findByName(String name);
  List<T> findAll();
  void update(UUID id, Consumer<T>... updates) throws Exception;
  void save(T entity);
  void remove(UUID id);
  String getTableName();
}
