package br.com.gabriel.config.producers;

import br.com.gabriel.config.annotations.JSONFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.inject.Produces;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
public class ObjectMapperProducer {

  @Produces
  @JSONFormatter
  public ObjectMapper createObjectMapper() {
    return new ObjectMapper();
  }

}
