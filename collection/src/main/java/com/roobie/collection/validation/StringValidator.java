package com.roobie.collection.validation;

public class StringValidator {
  public static boolean isValid(String input) {
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
