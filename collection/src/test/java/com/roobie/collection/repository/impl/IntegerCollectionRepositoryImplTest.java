package com.roobie.collection.repository.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.specification.impl.AverageSpecification;
import com.roobie.collection.specification.impl.CollectionSpecification;
import com.roobie.collection.specification.impl.IdSpecification;
import com.roobie.collection.util.MoreLess;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IntegerCollectionRepositoryImplTest {
  static IntegerCollectionRepositoryImpl repository = IntegerCollectionRepositoryImpl.getInstance();
  IdSpecification idSpecification;
  CollectionSpecification collectionSpecification;
  IntegerCollection collection;

  @BeforeAll
  static void setUp() {
    IntegerCollection collection1 = new IntegerCollection(new int[]{1, 2, 3});
    IntegerCollection collection2 = new IntegerCollection(new int[]{4, 5, 6});
    IntegerCollection collection3 = new IntegerCollection(new int[]{7, 8, 9});
    IntegerCollection collection4 = new IntegerCollection(new int[]{10, 11, 12});
    repository.add(collection1);
    repository.add(collection2);
    repository.add(collection3);
    repository.add(collection4);
  }

  @Test
  void queryById() {
    int[] expected = new int[]{1, 2, 3};
    idSpecification = new IdSpecification(1);

    Optional<IntegerCollection> result = repository.queryById(idSpecification);
    if (result.isPresent()) {
      collection = result.get();
      int[] actual = collection.getCollection();
      assertArrayEquals(expected, actual);
    } else {
      fail("Collection not found");
    }
  }

  @Test
  void queryByCollection() {
    int[] expected = new int[]{1, 2, 3};
    collectionSpecification = new CollectionSpecification(new int[]{1, 2, 3});

    Optional<List<IntegerCollection>> result = repository.queryByCollection(collectionSpecification);
    if (result.isPresent()) {
      collection = result.get().get(0);
      int[] actual = collection.getCollection();
      assertArrayEquals(expected, actual);
    } else {
      fail("Collection not found");
    }

  }

  @Test
  void queryByAverage() throws IntegerCollectionException {
    int[] expected = new int[]{1, 2, 3};

    double averageValue = 4.0;
    List<IntegerCollection> result = repository.queryByAverage(MoreLess.LESS, averageValue).get();
    int[] actual = result.get(0).getCollection();
    assertArrayEquals(expected, actual);
  }

  @Test
  void add() {
    int[] expected = new int[]{1, 2, 3};

    IntegerCollection collection = new IntegerCollection(new int[]{1, 2, 3});
    IntegerCollection result = repository.add(collection);
    int[] actual = result.getCollection();

    assertArrayEquals(expected, actual);
  }

  @Test
  void remove() {
    collection = new IntegerCollection(new int[]{1, 2, 3});
    repository.add(collection);
    boolean expected = true;
    boolean actual = repository.remove(5);
    assertEquals(expected, actual);
  }
}