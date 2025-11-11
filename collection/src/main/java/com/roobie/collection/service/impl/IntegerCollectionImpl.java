package com.roobie.collection.service.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IndexOutOfRangeException;
import com.roobie.collection.exception.NullCollectionException;
import com.roobie.collection.service.IntegerCollectionService;

import java.util.Arrays;
import java.util.HashMap;

public class IntegerCollectionImpl implements IntegerCollectionService {
  @Override
  public int findMinElement(IntegerCollection collection) throws NullCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new int[0])) {
      throw new NullCollectionException("Collection is null");
    }

    int min = collection.getCollection()[0];
    for (int i = 1; i < collection.getCollection().length; i++) {
      if (collection.getCollection()[i] < min) {
        min = collection.getCollection()[i];
      }
    }
    return min;
  }

  @Override
  public int findMaxElement(IntegerCollection collection) throws NullCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new int[0])) {
      throw new NullCollectionException("Collection is null");
    }

    int max = collection.getCollection()[0];
    for (int i = 1; i < collection.getCollection().length; i++) {
      if (collection.getCollection()[i] > max) {
        max = collection.getCollection()[i];
      }
    }
    return max;
  }

  @Override
  public int replaceElement(IntegerCollection collection, int newElement, int index) throws IndexOutOfRangeException{
    if (index < 0 || index >= collection.getCollection().length) {
      throw new IndexOutOfRangeException("Index out of range");
    }

    var coll = collection.getCollection();
    int[] result = new int[coll.length];
    for (int i = 0; i < coll.length; i++) {
      result[i] = coll[i];
      if (i == index) {
        result[i] = newElement;
      }
    }
    collection.setCollection(result);
    return newElement;
  }

  @Override
  public double defineAverageValue(IntegerCollection collection) throws NullCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new int[0])) {
      throw new NullCollectionException("Collection is null");
    }

    var coll = collection.getCollection();
    double average;
    double sum = 0;
    for (int element : coll) {
      sum += element;
    }
    average = sum / coll.length;
    return average;
  }

  @Override
  public int defineSum(IntegerCollection collection) throws NullCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new int[0])) {
      throw new NullCollectionException("Collection is null");
    }

    var coll = collection.getCollection();
    int sum = 0;
    for (int element : coll) {
      sum += element;
    }
    return sum;
  }

  @Override
  public HashMap<String, Integer> countPositivesAndNegatives(IntegerCollection collection)
          throws NullCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new int[0])) {
      throw new NullCollectionException("Collection is null");
    }

    var coll = collection.getCollection();
    HashMap<String, Integer> map = new HashMap<>();
    map.put("positive", 0);
    map.put("negative", 0);
    map.put("zero", 0);
    for (int element : coll) {
      if (element > 0) {
        map.put("positive", map.get("positive") + 1);
      } else if (element < 0) {
        map.put("negative", map.get("negative") + 1);
      } else {
        map.put("zero", map.get("zero") + 1);
      }
    }
    return map;
  }
}
