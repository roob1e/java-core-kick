package com.roobie.collection.validation;

public interface Validator<T> {
  boolean isValid(T input);
}
