package com.roobie.collection.service;

import com.roobie.collection.entity.IntegerCollection;

import java.util.HashMap;

public interface IntegerCollectionService {
  int findMinElement(IntegerCollection collection);
  int findMaxElement(IntegerCollection collection);
  int replaceElement(IntegerCollection collection, int newElement, int index);
  double defineAverageValue(IntegerCollection collection);
  int defineSum(IntegerCollection collection);
  HashMap<String, Integer> countPositivesAndNegatives(IntegerCollection collection);
}
