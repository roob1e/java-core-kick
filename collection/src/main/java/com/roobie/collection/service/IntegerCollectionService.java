package com.roobie.collection.service;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;

import java.util.HashMap;

public interface IntegerCollectionService {
  int findMinElement(IntegerCollection collection) throws IntegerCollectionException;

  int findMaxElement(IntegerCollection collection) throws IntegerCollectionException;

  int replaceElement(IntegerCollection collection, int newElement, int index) throws IntegerCollectionException;

  double defineAverageValue(IntegerCollection collection) throws IntegerCollectionException;

  int defineSum(IntegerCollection collection) throws IntegerCollectionException;

  HashMap<String, Integer> countPositivesAndNegatives(IntegerCollection collection) throws IntegerCollectionException;
}
