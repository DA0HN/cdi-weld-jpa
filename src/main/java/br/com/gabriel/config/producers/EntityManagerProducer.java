package br.com.gabriel.config.producers;

import br.com.gabriel.config.annotations.MySQLDatabase;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
public class EntityManagerProducer {
  @Produces
  @PersistenceContext(unitName = "cdi-weld")
  @MySQLDatabase
  private EntityManager entityManager;
}
