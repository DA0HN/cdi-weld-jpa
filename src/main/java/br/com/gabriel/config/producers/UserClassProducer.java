package br.com.gabriel.config.producers;

import br.com.gabriel.config.annotations.UserClass;
import br.com.gabriel.models.User;

import javax.enterprise.inject.Produces;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
public class UserClassProducer {

  @Produces
  @UserClass
  public Class<User> createUserClass() {
    return User.class;
  }

}
