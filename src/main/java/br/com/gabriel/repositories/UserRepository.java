package br.com.gabriel.repositories;

import br.com.gabriel.config.annotations.MySQLDatabase;
import br.com.gabriel.config.annotations.UserClass;
import br.com.gabriel.models.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
public class UserRepository extends BaseRepository<User> {

  @Inject
  public UserRepository(@MySQLDatabase EntityManager manager,
                        @UserClass Class<User> entityClass) {
    super(manager, entityClass);
  }

  @Override public String getTableName() {
    return "user";
  }
}
