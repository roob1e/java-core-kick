package com.roobie.collection.repository;

import com.roobie.collection.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository<T> {
  Optional<List<T>> query(Specification<T> specification);

  List<T> add(T[] collections) throws Throwable;

  boolean remove(long id) throws Throwable;

  List<T> fetchAll();

  List<T> sort();
}
