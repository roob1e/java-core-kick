package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.specification.Specification;

public class IdSpecification implements Specification {
  private final int id;

  public IdSpecification(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public boolean specify(IntegerCollection collection) {
    return collection.getCollectionId() == this.id;
  }
}
