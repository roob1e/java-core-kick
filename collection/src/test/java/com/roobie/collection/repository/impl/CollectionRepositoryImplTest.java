package com.roobie.collection.repository.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.specification.Specification;
import com.roobie.collection.specification.impl.AverageSpecification;
import com.roobie.collection.specification.impl.CollectionSpecification;
import com.roobie.collection.specification.impl.IdSpecification;
import com.roobie.collection.util.Sign;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CollectionRepositoryImplTest {
  static CollectionRepositoryImpl repository = CollectionRepositoryImpl.getInstance();
  IdSpecification idSpecification;
  CollectionSpecification collectionSpecification;
  List<IntegerCollection> collections;

  @BeforeAll
  static void setUp() throws IntegerCollectionException {
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
  void queryById() throws IntegerCollectionException {
    int[] expected = new int[]{1, 2, 3};
    idSpecification = new IdSpecification(1);

    Optional<List<IntegerCollection>> result = repository.query(idSpecification);
    if (result.isPresent()) {
      collections = result.get();
      int[] actual = collections.getFirst().getCollection();
      assertArrayEquals(expected, actual);
    } else {
      fail("Collection not found");
    }
  }

  @Test
  void queryByCollection() throws IntegerCollectionException {
    int[] expected = new int[]{1, 2, 3};
    collectionSpecification = new CollectionSpecification(new int[]{1, 2, 3});

    Optional<List<IntegerCollection>> result = repository.query(collectionSpecification);
    if (result.isPresent()) {
      collections = result.get();
      int[] actual = collections.getFirst().getCollection();
      assertArrayEquals(expected, actual);
    } else {
      fail("Collection not found");
    }
  }

  @Test
  void queryByAverage() throws IntegerCollectionException {
    int[] expected = new int[]{1, 2, 3};

    double averageValue = 3.1;
    Specification specification = new AverageSpecification(averageValue, Sign.LESS);

    List<IntegerCollection> result = repository.query(specification).get();
    int[] actual = result.getFirst().getCollection();
    assertArrayEquals(expected, actual);
  }

  @Test
  void add() throws IntegerCollectionException {
    int[] expected = new int[]{1, 2, 3};

    IntegerCollection collection = new IntegerCollection(new int[]{1, 2, 3});
    IntegerCollection result = repository.add(collection);
    int[] actual = result.getCollection();

    assertArrayEquals(expected, actual);
  }

  @Test
  void remove() throws IntegerCollectionException {
    var collection = new IntegerCollection(new int[]{1, 2, 3});
    repository.add(collection);
    boolean expected = true;
    boolean actual = repository.remove(5);
    assertEquals(expected, actual);
  }
}