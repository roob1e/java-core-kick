package com.roobie.collection.service.impl;

import com.roobie.collection.entity.IntegerCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class IntegerCollectionImplTest {
  IntegerCollection collection;
  IntegerCollectionImpl impl = new IntegerCollectionImpl();

  @BeforeEach
  void setUp() {
    collection = new IntegerCollection().builder()
            .collection(new int[] {1, 2, 3}).build();
  }

  @AfterEach
  void tearDown() {
    collection = null;
  }

  @Test
  void findMinElement() {
    int expected = 1;
    int actual = impl.findMinElement(collection);
    assertEquals(expected, actual);
  }

  @Test
  void findMaxElement() {
    int expected = 3;
    int actual = impl.findMaxElement(collection);
    assertEquals(expected, actual);
  }

  @Test
  void replaceElement() {
    int newValue = 0;
    int expected = 0;
    int actual = impl.replaceElement(collection, newValue, 2);
    assertEquals(expected, actual);
  }

  @Test
  void defineAverageValue() {
    double expected = 2.0;
    double actual = impl.defineAverageValue(collection);
    assertEquals(expected, actual);
  }

  @Test
  void defineSum() {
    int expected = 6;
    int actual = impl.defineSum(collection);
    assertEquals(expected, actual);
  }

  @Test
  void countPositivesAndNegatives() {
    HashMap<String, Integer> expected = new HashMap<>();
    expected.put("positive", 3);
    expected.put("negative", 0);
    expected.put("zero", 0);
    var actual = impl.countPositivesAndNegatives(collection);
    assertEquals(expected, actual);
  }
}