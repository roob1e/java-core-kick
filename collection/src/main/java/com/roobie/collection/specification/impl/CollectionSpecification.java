package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.specification.Specification;

import java.util.Arrays;

public class CollectionSpecification implements Specification {
  private final int[] collection;

  public CollectionSpecification(int[] collection) {
    this.collection = collection;
  }

  public int[] getCollection() {
    return this.collection.clone();
  }

  @Override
  public boolean specify(IntegerCollection collection) {
    return Arrays.equals(this.collection, collection.getCollection());
  }
}
