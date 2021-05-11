package br.com.gabriel.service;

import br.com.gabriel.config.annotations.JSONFormatter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
@Named
public class ToStringFormatterService {

  private ObjectMapper mapper;

  @Inject
  public ToStringFormatterService(@JSONFormatter ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public String format(Object target) throws JsonProcessingException {
    var writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
    return writer.writeValueAsString(target);
  }
}
