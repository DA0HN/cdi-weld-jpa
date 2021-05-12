package br.com.gabriel.config.producers;

import br.com.gabriel.config.annotations.InputReader;

import javax.enterprise.inject.Produces;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by daohn on 12/05/2021
 * @author daohn
 * @since 12/05/2021
 */
public class InputReaderProducer {

  @Produces
  @InputReader
  public BufferedReader createInputReader() {
    return new BufferedReader(new InputStreamReader(System.in));
  }

}
