package com.roobie.collection.warehouse;

import com.roobie.collection.entity.CollectionStats;
import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;

import java.util.HashMap;

public interface Warehouse {
  HashMap<Long, CollectionStats> getStorage();

  CollectionStats getStats(long collectionId);

  void registerRecord(IntegerCollection collection);

  void removeRecord(IntegerCollection collection);

  void updateRecord(IntegerCollection collection);
}
