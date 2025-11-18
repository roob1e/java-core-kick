package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.specification.Specification;

public class IdSpecification implements Specification {
  private final long id;

  public IdSpecification(long id) {
    this.id = id;
  }

  public long getId() {
    return this.id;
  }

  @Override
  public boolean specify(IntegerCollection collection) {
    return collection.getCollectionId() == this.id;
  }
}
