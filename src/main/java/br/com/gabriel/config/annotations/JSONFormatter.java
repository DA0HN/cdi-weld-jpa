package br.com.gabriel.config.annotations;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by daohn on 11/05/2021
 * @author daohn
 * @since 11/05/2021
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD,
          ElementType.TYPE, ElementType.PARAMETER})
public @interface JSONFormatter {
}
