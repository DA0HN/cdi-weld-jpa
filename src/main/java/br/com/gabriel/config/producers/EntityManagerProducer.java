package br.com.gabriel.config.producers;

import br.com.gabriel.config.annotations.MySQLDatabase;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
public class EntityManagerProducer {
  @Produces
  @MySQLDatabase
  public EntityManager createEntityManager() {
    return Persistence
             .createEntityManagerFactory("cdi-weld")
             .createEntityManager();
  }

  public void close(
    @Disposes @MySQLDatabase EntityManager entityManager) {
    entityManager.close();
  }
}
