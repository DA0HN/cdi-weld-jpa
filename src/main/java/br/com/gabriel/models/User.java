package br.com.gabriel.models;

import br.com.gabriel.service.ToStringFormatterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.annotations.GenericGenerator;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
  // https://phauer.com/2016/uuids-hibernate-mysql/
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;
  private String name;
  private String email;

  @Inject
  @Transient
  private ToStringFormatterService formatterService;

  public User() {
  }

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ToStringFormatterService getFormatterService() {
    return formatterService;
  }

  public void setFormatterService(ToStringFormatterService formatterService) {
    this.formatterService = formatterService;
  }

  @Override public String toString() {
    try {
      return this.formatterService.format(this);
    }
    catch(JsonProcessingException e) {
      e.printStackTrace();
    }
    return "Não foi possível formatar o objeto 'User'.";
  }
}
