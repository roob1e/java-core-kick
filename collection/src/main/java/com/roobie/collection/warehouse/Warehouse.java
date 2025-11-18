package com.roobie.collection.warehouse;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;

import java.util.HashMap;

public interface Warehouse {
  HashMap<Long, HashMap<String, Double>> getStorage();

  HashMap<String, Double> getRecord(long collectionId);

  void registerRecord(IntegerCollection collection) throws IntegerCollectionException;

  void removeRecord(IntegerCollection collection) ;

  void updateRecord(IntegerCollection collection) throws IntegerCollectionException;

}
