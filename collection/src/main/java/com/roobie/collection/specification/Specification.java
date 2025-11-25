package com.roobie.collection.specification;

public interface Specification<T> {
  boolean specify(T collection);
}