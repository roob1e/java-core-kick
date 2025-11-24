package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.impl.BasicServiceImpl;
import com.roobie.collection.specification.Specification;
import com.roobie.collection.util.Sign;

public record AverageSpecification(double average, Sign sign) implements Specification {
  @Override
  public boolean specify(IntegerCollection collection) throws IntegerCollectionException {
    double average = new BasicServiceImpl().defineAverageValue(collection);
    return switch (sign) {
      case EQUAL -> average == this.average;
      case MORE -> average > this.average;
      case LESS -> average < this.average;
    };
  }
}
