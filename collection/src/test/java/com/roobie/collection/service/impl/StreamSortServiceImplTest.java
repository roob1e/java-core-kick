package com.roobie.collection.service.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamSortServiceImplTest {
  StreamSortServiceImpl service;
  IntegerCollection collection;

  @BeforeEach
  void setUp() {
    service = new StreamSortServiceImpl();
    collection = new IntegerCollection(new Integer[] {3, 1, 2});
  }

  @AfterEach
  void tearDown() {
    service = null;
  }

  @Test
  void sort() {
    Integer[] expected = new Integer[] {1, 2, 3};
    Integer[] actual = service.sort(collection).getCollection();
    assertArrayEquals(expected, actual);
  }

  @Test
  void reverseSort() {
    Integer[] expected = new Integer[] {3, 2, 1};
    Integer[] actual = service.reverseSort(collection).getCollection();
    assertArrayEquals(expected, actual);
  }
}