package com.roobie.collection.repository.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.warehouse.Warehouse;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RepositoryObserverTest {
  CollectionRepositoryImpl repository = CollectionRepositoryImpl.getInstance();
  Warehouse warehouse = Warehouse.getInstance();

  @Test
  @Order(1)
  void add() throws IntegerCollectionException {
    Set<Long> expected = new HashSet<>();
    expected.add(1L);
    expected.add(2L);
    expected.add(3L);

    IntegerCollection collection1 = new IntegerCollection(new int[]{1, 2, 3});
    IntegerCollection collection2 = new IntegerCollection(new int[]{4, 5, 6});
    IntegerCollection collection3 = new IntegerCollection(new int[]{7, 8, 9});
    repository.add(collection1);
    repository.add(collection2);
    repository.add(collection3);
    Set<Long> actual = warehouse.getStorage().keySet();

    assertEquals(expected, actual);
  }

  @Test
  @Order(2)
  void remove() throws IntegerCollectionException {
    Set<Long> expected = new HashSet<>();
    expected.add(1L);
    expected.add(2L);

    repository.remove(3L);
    Set<Long> actual = warehouse.getStorage().keySet();
    assertEquals(expected, actual);
  }
}