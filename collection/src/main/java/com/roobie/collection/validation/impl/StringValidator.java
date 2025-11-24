package com.roobie.collection.validation.impl;

import com.roobie.collection.validation.Validator;

public class StringValidator implements Validator<String> {
  public boolean isValid(String input) {
    String alpha = ".*[a-zA-Zа-яА-Я].*";
    String special = ".*[!\"#$%&'()*+./:;<=>?@\\[\\\\\\]^_`{|}~].*";
    if (input == null || input.trim().isEmpty()) {
      return false;
    }
    if (input.matches(alpha)) {
      return false;
    }
    if (input.matches(special)) {
      return false;
    }
    return true;
  }
}
