package com.roobie.collection.factory.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.factory.Factory;
import com.roobie.collection.observer.Observer;

import java.util.Arrays;
import java.util.Random;

public class IntegerCollectionFactory implements Factory<IntegerCollection, Integer> {
  private static final Random random = new Random();
  private int randomBound = 10;

  public IntegerCollectionFactory() {}

  public int getRandomBound() {
    return randomBound;
  }

  public void setRandomBound(int randomBound) {
    this.randomBound = randomBound;
  }

  @Override
  public IntegerCollection createEmpty() {
    return new IntegerCollection();
  }

  @Override
  public IntegerCollection createFromArray(Integer[] array) {
    return new IntegerCollection().builder()
            .collection(Arrays.copyOf(array, array.length))
            .build();
  }

  @Override
  public IntegerCollection createRandom(int size) {
    Integer[] array = new Integer[size];
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(10) - 11;
    }
    return createFromArray(array);
  }

  @Override
  public IntegerCollection createFull(Integer[] array, Observer... observers) {
    return new IntegerCollection().builder()
            .collection(Arrays.copyOf(array, array.length))
            .observers(observers)
            .build();
  }

  @Override
  public IntegerCollection createFullRandom(int size, Observer... observers) {
    Integer[] array = new Integer[size];
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(10) - 10;
    }
    return createFull(array, observers);
  }
}
