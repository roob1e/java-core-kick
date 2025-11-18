package com.roobie.collection.service;

import com.roobie.collection.exception.IntegerCollectionException;

public interface SortCollectionService {
  int[] bubbleSort(int[] array) throws IntegerCollectionException;

  int[] selectionSort(int[] array) throws IntegerCollectionException;

  int[] insertionSort(int[] array) throws IntegerCollectionException;
}
