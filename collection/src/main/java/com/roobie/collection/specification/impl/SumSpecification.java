package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.impl.BasicServiceImpl;
import com.roobie.collection.specification.Specification;
import com.roobie.collection.util.Sign;

public record SumSpecification(int sum, Sign sign) implements Specification {
  @Override
  public boolean specify(IntegerCollection collection) {
    try {
      int value = new BasicServiceImpl().defineSum(collection);
      return switch (sign) {
        case EQUAL -> value == sum;
        case LESS -> value < sum;
        case MORE -> value > sum;
      };
    } catch (IntegerCollectionException e) {
      return false;
    }
  }
}
