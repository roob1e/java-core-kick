package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.impl.BasicServiceImpl;
import com.roobie.collection.specification.Specification;

public record SumSpecification(int sum) implements Specification {
  @Override
  public boolean specify(IntegerCollection collection) {
    try {
      int value = new BasicServiceImpl().defineSum(collection);
      return value == sum;
    } catch (IntegerCollectionException e) {
      return false;
    }
  }
}
