package com.roobie.collection.repository;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository {
  Optional<List<IntegerCollection>> query(Specification specification) throws IntegerCollectionException;

  IntegerCollection add(IntegerCollection collection) throws IntegerCollectionException;

  boolean remove(long id) throws IntegerCollectionException;

  List<IntegerCollection> fetchAll();


}
