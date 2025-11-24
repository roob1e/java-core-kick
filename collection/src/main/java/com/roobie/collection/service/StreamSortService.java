package com.roobie.collection.service;

import com.roobie.collection.entity.impl.IntegerCollection;

public interface StreamSortService {
  IntegerCollection sort(IntegerCollection collection);
  IntegerCollection reverseSort(IntegerCollection collection);
}
