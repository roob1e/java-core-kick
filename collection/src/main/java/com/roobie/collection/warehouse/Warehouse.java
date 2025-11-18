package com.roobie.collection.warehouse;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.repository.impl.IntegerCollectionRepositoryImpl;
import com.roobie.collection.service.impl.IntegerCollectionImpl;
import com.roobie.collection.specification.impl.IdSpecification;

import java.util.HashMap;

public class Warehouse {
  private static Warehouse instance;
  private HashMap<Integer, HashMap<String, Double>> storage;

  private Warehouse() {
    storage = new HashMap<>();
  }

  public static Warehouse getInstance() {
    if (instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }

  public HashMap<Integer, HashMap<String, Double>> getStorage() {
    return storage;
  }

  public HashMap<String, Double> getRecord(int collectionId) throws IntegerCollectionException {
    return storage.get(collectionId);
  }

  public HashMap<Integer, HashMap<String, Double>> registerRecord(int collectionId)
          throws IntegerCollectionException {
    IntegerCollectionRepositoryImpl repository = IntegerCollectionRepositoryImpl.getInstance();
    IdSpecification specification = new IdSpecification(collectionId);
    IntegerCollection collection = repository.queryById(specification).get();
    HashMap<String, Double> record = new HashMap<>();

    IntegerCollectionImpl service = new IntegerCollectionImpl();

    double average = service.defineAverageValue(collection);
    record.put("average", average);

    double min = service.findMinElement(collection);
    record.put("min", min);

    double max = service.findMaxElement(collection);
    record.put("max", max);

    double length = collection.getCollection().length;
    record.put("length", length);

    storage.put(collectionId, record);

    HashMap<Integer, HashMap<String, Double>> result = new HashMap<>();
    result.put(collectionId, record);
    return result;
  }

  public void removeRecord(int collectionId) throws IntegerCollectionException {
    storage.remove(collectionId);
  }


}
