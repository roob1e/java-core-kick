package com.roobie.collection.service.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.BasicService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class StreamBasicServiceImpl implements BasicService {
  @Override
  public Integer findMinElement(IntegerCollection collection) throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }

    return Arrays.stream(collection.getCollection())
            .mapToInt(Integer::intValue)
            .min()
            .orElse(0);
  }

  @Override
  public Integer findMaxElement(IntegerCollection collection) throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }

    return Arrays.stream(collection.getCollection())
            .mapToInt(Integer::intValue)
            .max()
            .orElse(0);
  }

  @Override
  public Integer replaceElement(IntegerCollection collection, Integer element, int index)
    throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }

    Integer[] array = collection.getCollection();

    if (index >= 0 && index < array.length) {
      Integer[] result = IntStream.range(0, collection.size())
              .mapToObj(i -> i == index ? element : collection.getCollection()[i])
              .toArray(Integer[]::new);
      collection.setCollection(result);
      return element;
    }
    throw new IntegerCollectionException("Element not found");
  }

  @Override
  public double defineAverageValue(IntegerCollection collection) throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }

    Integer[] array = collection.getCollection();

    return Arrays.stream(array)
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0);
  }

  @Override
  public int defineSum(IntegerCollection collection) throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }
    Integer[] array = collection.getCollection();
    return Arrays.stream(array)
            .mapToInt(Integer::intValue)
            .sum();
  }

  @Override
  public HashMap<String, Integer> countPositivesAndNegatives(IntegerCollection collection)
    throws IntegerCollectionException {
    if (collection.getCollection() == null || Arrays.equals(collection.getCollection(), new Integer[0])) {
      throw new IntegerCollectionException("Collection is null");
    }
    HashMap<String, Integer> result = new HashMap<>();
    result.put("positive", 0);
    result.put("negative", 0);
    result.put("zero", 0);

    Arrays.stream(collection.getCollection())
            .forEach(element -> {
              if (element < 0) {
                result.put("negative", result.get("negative") + 1);
              } else if (element > 0) {
                result.put("positive", result.get("positive") + 1);
              } else {
                result.put("zero", result.get("zero") + 1);
              }
            });

    return result;
  }
}
