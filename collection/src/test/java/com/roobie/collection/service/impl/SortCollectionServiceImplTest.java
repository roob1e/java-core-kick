package com.roobie.collection.service.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortCollectionServiceImplTest {
  IntegerCollection collection;
  SortCollectionServiceImpl impl = new SortCollectionServiceImpl();

  @BeforeEach
  void setUp() {
    collection = new IntegerCollection(new int[]{5, 1, 2, 8, 3});
  }

  @AfterEach
  void tearDown() {
    collection = null;
  }

  @Test
  void bubbleSort() throws IntegerCollectionException {
    int[] expected = new int[]{1, 2, 3, 5, 8};
    int[] actual = impl.bubbleSort(collection.getCollection());
    assertArrayEquals(expected, actual);
  }

  @Test
  void insertionSort() throws IntegerCollectionException {
    int[] expected = new int[]{1, 2, 3, 5, 8};
    int[] actual = impl.insertionSort(collection.getCollection());
    assertArrayEquals(expected, actual);
  }

  @Test
  void selectionSort() throws IntegerCollectionException {
    int[] expected = new int[]{1, 2, 3, 5, 8};
    int[] actual = impl.selectionSort(collection.getCollection());
    assertArrayEquals(expected, actual);
  }
}