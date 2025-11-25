package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.specification.Specification;

import java.util.Arrays;

public record CollectionSpecification(Integer[] collection) implements Specification<IntegerCollection> {
  @Override
  public boolean specify(IntegerCollection collection) {
    return Arrays.equals(this.collection, collection.getCollection());
  }
}
