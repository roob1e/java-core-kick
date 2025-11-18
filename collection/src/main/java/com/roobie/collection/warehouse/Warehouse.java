package com.roobie.collection.warehouse;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.service.impl.BasicCollectionServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Warehouse {
  private static final Logger logger = LogManager.getLogger();
  private static Warehouse instance;
  private final HashMap<Long, HashMap<String, Double>> storage;

  private Warehouse() {
    storage = new HashMap<>();
  }

  public static Warehouse getInstance() {
    if (instance == null) {
      logger.info("Creating new instance of Warehouse");
      instance = new Warehouse();
    }
    return instance;
  }

  public HashMap<Long, HashMap<String, Double>> getStorage() {
    logger.info("Getting storage of Warehouse");
    return storage;
  }

  public HashMap<String, Double> getRecord(long collectionId) {
    if (storage.containsKey(collectionId)) {
      logger.info("Got record of Warehouse: {}", storage.get(collectionId));
      return storage.get(collectionId);
    }
    return new HashMap<>();
  }

  public void registerRecord(IntegerCollection collection)
          throws IntegerCollectionException {
    long collectionId = collection.getCollectionId();
    HashMap<String, Double> metrics = calculateMetrics(collection);
    storage.put(collectionId, metrics);

    HashMap<Long, HashMap<String, Double>> result = new HashMap<>();
    result.put(collectionId, metrics);
    logger.info("Registered record of Warehouse: {}", result);
  }

  public void removeRecord(IntegerCollection collection) {
    long collectionId = collection.getCollectionId();
    logger.info("Removing record of Warehouse with id: {}", collectionId);
    storage.remove(collectionId);
  }

  public void updateRecord(IntegerCollection collection) throws IntegerCollectionException {
    long collectionId = collection.getCollectionId();
    HashMap<String, Double> metrics = calculateMetrics(collection);
    storage.put(collectionId, metrics);
    logger.info("Updated record of Warehouse with id: {}", collectionId);
  }

  private HashMap<String, Double> calculateMetrics(IntegerCollection collection)
          throws IntegerCollectionException {
    HashMap<String, Double> result = new HashMap<>();
    BasicCollectionServiceImpl service = new BasicCollectionServiceImpl();

    result.put("average", service.defineAverageValue(collection));
    result.put("min", (double) service.findMinElement(collection));
    result.put("max", (double) service.findMaxElement(collection));
    result.put("length", (double) collection.getCollection().length);
    return result;
  }
}