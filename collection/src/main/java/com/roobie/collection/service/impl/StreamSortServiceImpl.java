package com.roobie.collection.service.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.service.StreamSortService;

import java.util.Arrays;
import java.util.Comparator;

public class StreamSortServiceImpl implements StreamSortService {
  @Override
  public IntegerCollection sort(IntegerCollection collection) {
    Integer[] array = collection.getCollection();
    Integer[] result = Arrays.stream(array)
            .sorted()
            .toArray(Integer[]::new);
    collection.setCollection(result);
    return collection;
  }

  @Override
  public IntegerCollection reverseSort(IntegerCollection collection) {
    Integer[] array = collection.getCollection();
    Integer[] result = Arrays.stream(array)
            .sorted(Comparator.reverseOrder())
            .toArray(Integer[]::new);
    collection.setCollection(result);
    return collection;
  }
}