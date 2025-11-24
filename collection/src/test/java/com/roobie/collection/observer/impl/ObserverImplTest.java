package com.roobie.collection.observer.impl;

import com.roobie.collection.entity.CollectionStats;
import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.observer.Observer;
import com.roobie.collection.util.Events;
import com.roobie.collection.warehouse.Warehouse;
import com.roobie.collection.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverImplTest {
  static Warehouse warehouse;
  static Observer observer;
  static IntegerCollection collection;

  @BeforeAll
  static void setUp() {
    warehouse = WarehouseImpl.getInstance();
    observer = new ObserverImpl(warehouse);
  }

  @Test
  void update() {
    CollectionStats expected = new CollectionStats(2.0, 1, 3, 6);

    collection = new IntegerCollection(new Integer[]{1, 2, 3});
    observer.update(Events.CREATE, collection);
    CollectionStats actual = warehouse.getStorage().get(collection.getCollectionId());

    assertEquals(expected, actual);
  }
}