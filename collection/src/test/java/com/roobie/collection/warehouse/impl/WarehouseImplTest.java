package com.roobie.collection.warehouse.impl;

import com.roobie.collection.entity.CollectionStats;
import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.warehouse.Warehouse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseImplTest {
  static Warehouse warehouse;
  static IntegerCollection collection;

  @BeforeAll
  static void setUp() {
    warehouse = WarehouseImpl.getInstance();
    collection = new IntegerCollection(new Integer[]{1, 2, 3});
  }


  @Test
  void registerRecord() {
    int expected = 1;
    warehouse.registerRecord(collection);
    int actual = warehouse.getStorage().size();
    assertEquals(expected, actual);
  }

  @Test
  void removeRecord() {
    int expected = 0;
    warehouse.removeRecord(collection);
    int actual = warehouse.getStorage().size();
    assertEquals(expected, actual);
  }

  @Test
  void updateRecord() {
    CollectionStats expected = new CollectionStats(1.0, 1, 1, 3);

    warehouse.registerRecord(collection);
    collection.setCollection(new Integer[]{1, 1, 1});
    warehouse.updateRecord(collection);
    CollectionStats actual = warehouse.getStats(1);

    assertEquals(expected, actual);
  }
}