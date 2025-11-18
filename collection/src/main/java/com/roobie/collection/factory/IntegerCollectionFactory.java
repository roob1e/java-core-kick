package com.roobie.collection.factory;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;

import java.util.Arrays;
import java.util.Random;

public class IntegerCollectionFactory {
  private static final Random RANDOM = new Random();

  private IntegerCollectionFactory() {}

  public static IntegerCollection createEmpty() throws IntegerCollectionException {
    IntegerCollection collection = new IntegerCollection();
    collection.setCollection(new int[0]);
    return collection;
  }

  public static IntegerCollection createFromArray(int[] array) {
    return new IntegerCollection().builder()
            .collection(Arrays.copyOf(array, array.length))
            .build();
  }

  public static IntegerCollection createRandom(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = RANDOM.nextInt(-10, 10);
    }
    return createFromArray(array);
  }
}
