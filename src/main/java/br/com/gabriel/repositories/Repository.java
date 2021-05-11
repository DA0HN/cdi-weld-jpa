package br.com.gabriel.repositories;

import br.com.gabriel.config.annotations.MySQLDatabase;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
public class Repository {

  private final EntityManager manager;

  @Inject
  public Repository(@MySQLDatabase EntityManager manager) {
    this.manager = manager;
  }

}
