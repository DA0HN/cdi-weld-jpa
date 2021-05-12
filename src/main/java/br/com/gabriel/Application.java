package br.com.gabriel;

import br.com.gabriel.service.UserService;
import org.jboss.weld.environment.se.Weld;

/**
 * Created by daohn on 10/05/2021
 * @author daohn
 * @since 10/05/2021
 */
public class Application {

  public static void main(String[] args) throws Exception {
    var weld = new Weld();
    var container = weld.initialize();
    var userService = container.getBeanManager()
                                .createInstance()
                                .select(UserService.class)
                                .get();
    userService.run();
    weld.shutdown();
  }
}
