package com.roobie.collection.validation;

public interface Validator<T> {
  public boolean isValid(T input);
}
