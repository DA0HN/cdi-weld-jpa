package br.com.gabriel.service;

import br.com.gabriel.config.annotations.InputReader;
import br.com.gabriel.models.User;
import br.com.gabriel.repositories.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by daohn on 12/05/2021
 * @author daohn
 * @since 12/05/2021
 */
public class UserService {

  private final UserRepository repository;
  private final BufferedReader inputReader;

  @Inject
  public UserService(UserRepository repository,
                     @InputReader BufferedReader inputReader) {
    this.repository = repository;
    this.inputReader = inputReader;
  }


  public void run() throws Exception {
    var isRunning = true;
    while(isRunning) {
      System.out.println("Enter an option: "
                           + "1) Insert a new user. "
                           + "2) Find a user. "
                           + "3) List all users "
                           + "4) Edit a user. "
                           + "5) Delete a user. "
                           + "6) Quit the application");
      isRunning = runUserOperation(readUserInput());
    }
  }

  private boolean runUserOperation(String option) throws Exception {
    switch(option) {
      case "1":
        persistNewUser();
        return true;
      case "2":
        fetchExistingUser();
        return true;
      case "3":
        fetchAllExistingUsers();
        return true;
      case "4":
        updateExistingUser();
        return true;
      case "5":
        removeExistingUser();
        return true;
      case "6":
        return false;
    }
    return true;
  }

  private void persistNewUser() throws IOException {
    String name = requestStringInput("the name of the user");
    String email = requestStringInput("the email of the user");
    repository.save(new User(name, email));
  }

  private void fetchExistingUser() throws IOException {
    String name = requestStringInput("the user name");
    List<User> users = repository.findByName(name);
    users.forEach(System.out::println);
  }

  private void fetchAllExistingUsers() throws IOException {
    repository.findAll().forEach(System.out::println);
  }

  private void updateExistingUser() throws Exception {
    var userFound = fetchUserByName();
    var newName = requestStringInput("the new name of the user");
    var newEmail = requestStringInput("the new email of the user");

    repository.update(userFound.getId(),
                      user -> user.setName(newName),
                      user -> user.setEmail(newEmail)
    );
  }

  private User fetchUserByName() throws IOException {
    var name = requestStringInput("the name of the user");
    return repository
             .findByName(name)
             .stream()
             .filter(u -> u.getName().equalsIgnoreCase(name))
             .findFirst()
             .get();
  }

  private void removeExistingUser() throws IOException {
    var userFound = fetchUserByName();
    repository.remove(userFound.getId());
  }

  private String readUserInput() throws IOException {
    return inputReader.readLine();
  }

  private String requestStringInput(String request) throws IOException {
    System.out.printf("Enter %s: ", request);
    return readUserInput();
  }

  private int requestIntegerInput(String request) throws IOException {
    System.out.printf("Enter %s: ", request);
    return Integer.parseInt(readUserInput());
  }


}
