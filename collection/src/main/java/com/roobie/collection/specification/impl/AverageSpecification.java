package com.roobie.collection.specification.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.impl.IntegerCollectionImpl;
import com.roobie.collection.specification.Specification;
import com.roobie.collection.util.MoreLess;

public class AverageSpecification implements Specification {
  private final double average;
  private final MoreLess sign;
  private final IntegerCollectionImpl service = new IntegerCollectionImpl();

  public AverageSpecification(double average, MoreLess sign) {
    this.average = average;
    this.sign = sign;
  }

  public double getAverage() {
    return average;
  }

  public MoreLess getSign() {
    return sign;
  }

  @Override
  public boolean specify(IntegerCollection collection) throws IntegerCollectionException {
    double average = service.defineAverageValue(collection);
    if (sign == MoreLess.MORE) {
      return average > this.average;
    } else {
      return average < this.average;
    }
  }
}
