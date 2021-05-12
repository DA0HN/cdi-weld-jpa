package br.com.gabriel.repositories;

import br.com.gabriel.models.User;

import javax.persistence.EntityManager;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
public class UserRepository extends BaseRepository<User> {

  public UserRepository(EntityManager manager, Class<User> entityClass) {
    super(manager, entityClass);
  }

  @Override public String getTableName() {
    return "User";
  }
}
