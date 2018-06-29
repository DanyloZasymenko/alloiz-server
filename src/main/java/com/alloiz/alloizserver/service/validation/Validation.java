package com.alloiz.alloizserver.service.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.data.jpa.repository.JpaRepository;

public class Validation {

  public static void checkId(Long id) {
    if (id == null || id < 0)
      throw new IdException("invalid id");
  }

  public static void checkString(String string) {
    if (string == null)
      throw new FindException(string + " must be not null");
  }

  //use when json is parameter instead of object in save method
  public static void checkJson(String json) {
    try {
      new ObjectMapper().readTree(String.valueOf(json));
    } catch (NullPointerException | IOException e) {
      throw new RuntimeException("json is null or empty");
    }
  }


  //use when object is parameter
  public static void checkSave(Object object) {
    if (object == null)
      throw new SaveException(object + " is null");
  }

}
