package com.roobie.collection.validation.impl;

import com.roobie.collection.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorTest {
  static Validator<String> validator;
  static final String validString = "1, 2, 3";
  static final String invalidString1 = "3e, 1, 2";
  static final String invalidString2 = null;
  static final String invalidString3 = "1!-2-3";


  @BeforeAll
  static void setUp() {
    validator = new StringValidator();
  }

  @Test
  void trueCase() {
    boolean expected = true;
    boolean actual = validator.isValid(validString);
    assertEquals(expected, actual);
  }

  @Test
  void falseCase1() {
    boolean expected = false;
    boolean actual = validator.isValid(invalidString1);
    assertEquals(expected, actual);
  }

  @Test
  void falseCase2() {
    boolean expected = false;
    boolean actual = validator.isValid(invalidString2);
    assertEquals(expected, actual);
  }

  @Test
  void falseCase3() {
    boolean expected = false;
    boolean actual = validator.isValid(invalidString3);
    assertEquals(expected, actual);
  }
}