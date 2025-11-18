package com.roobie.collection.repository;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.specification.impl.AverageSpecification;
import com.roobie.collection.specification.impl.CollectionSpecification;
import com.roobie.collection.specification.impl.IdSpecification;
import com.roobie.collection.util.MoreLess;

import java.util.List;
import java.util.Optional;

public interface IntegerCollectionRepository {
  Optional<IntegerCollection> queryById(IdSpecification specification);

  Optional<List<IntegerCollection>> queryByCollection(CollectionSpecification specification);

  Optional<List<IntegerCollection>> queryByAverage(MoreLess sign, double value) throws IntegerCollectionException;

  IntegerCollection add(IntegerCollection collection);

  boolean remove(int id);

  List<IntegerCollection> fetchAll();


}
