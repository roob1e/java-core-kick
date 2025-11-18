package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.specification.Specification;

import java.util.Arrays;

public record CollectionSpecification(int[] collection) implements Specification {
  @Override
  public boolean specify(IntegerCollection collection) {
    return Arrays.equals(this.collection, collection.getCollection());
  }
}
