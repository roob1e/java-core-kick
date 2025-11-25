package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.specification.Specification;

public record IdSpecification(long id) implements Specification<IntegerCollection>{
  @Override
  public boolean specify(IntegerCollection collection) {
    return collection.getCollectionId() == this.id;
  }
}
