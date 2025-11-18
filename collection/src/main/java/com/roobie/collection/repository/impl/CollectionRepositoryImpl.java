package com.roobie.collection.repository.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.observer.impl.RepositoryObserver;
import com.roobie.collection.repository.CollectionRepository;
import com.roobie.collection.specification.impl.AverageSpecification;
import com.roobie.collection.specification.impl.CollectionSpecification;
import com.roobie.collection.specification.impl.IdSpecification;
import com.roobie.collection.util.Actions;
import com.roobie.collection.util.MoreLess;
import com.roobie.collection.warehouse.impl.WarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionRepositoryImpl implements CollectionRepository {
  private static final Logger logger = LogManager.getLogger();
  private static RepositoryObserver observer;
  private static CollectionRepositoryImpl instance;
  private final List<IntegerCollection> storage;

  public static CollectionRepositoryImpl getInstance() {
    if (instance == null) {
      instance = new CollectionRepositoryImpl();
      logger.info("Initialized repository");
    } else {
      logger.info("Returning an existing instance of CollectionRepositoryImpl");
    }
    return instance;
  }

  private CollectionRepositoryImpl() {
    storage = new ArrayList<IntegerCollection>();
    observer = new RepositoryObserver(WarehouseImpl.getInstance());
    logger.info("Initialized observer");
  }

  @Override
  public Optional<IntegerCollection> queryById(IdSpecification specification) {
    logger.info("Querying by id: {}", specification.getId());
    for (IntegerCollection collection : storage) {
      if (specification.specify(collection)) {
        logger.info("Found collection: {}", collection);
        return Optional.of(collection);
      }
    }
    logger.info("No collection found");
    return Optional.empty();
  }

  @Override
  public Optional<List<IntegerCollection>> queryByCollection(CollectionSpecification specification) {
    logger.info("Querying by collection: {}", specification.getCollection());
    List<IntegerCollection> response = new ArrayList<>();
    for (IntegerCollection collection : storage) {
      if (specification.specify(collection)) {
        logger.info("Found collection: {}", collection);
        response.add(collection);
      }
    }
    if (!response.isEmpty()) {
      logger.info("Found {} collections", response.size());
      return Optional.of(response);
    } else {
      logger.info("No collection found");
      return Optional.empty();
    }
  }

  @Override
  public Optional<List<IntegerCollection>> queryByAverage(MoreLess sign, double value)
          throws IntegerCollectionException {
    logger.info("Querying collection with average value {} than {}", sign, value);
    List<IntegerCollection> response = new ArrayList<>();
    AverageSpecification specification = new AverageSpecification(value, sign);

    for (IntegerCollection collection : storage) {
      if (specification.specify(collection)) {
        logger.info("Found collection: {}", collection);
        response.add(collection);
      }
    }
    if (!response.isEmpty()) {
      logger.info("Found {} collections", response.size());
      return Optional.of(response);
    } else {
      logger.info("No collection found");
      return Optional.empty();
    }
  }

  @Override
  public IntegerCollection add(IntegerCollection collection) throws IntegerCollectionException {
    logger.info("Adding collection: {}", collection.toString());
    storage.add(collection);
    notify(Actions.CREATE, collection);
    return collection;
  }

  @Override
  public boolean remove(long id) throws IntegerCollectionException {
    logger.info("Removing collection: {}", id);
    IdSpecification specification = new IdSpecification(id);
    for (IntegerCollection collection : storage) {
      if (specification.specify(collection)) {
        logger.info("Collection removed: {}", collection);
        storage.remove(collection);

        notify(Actions.DELETE, collection);
        return true;
      }
    }
    logger.info("Collection not found");
    return false;
  }

  @Override
  public List<IntegerCollection> fetchAll() {
    logger.info("Fetching all collections");
    return storage;
  }

  private void notify(Actions action, IntegerCollection collection) throws IntegerCollectionException {
    logger.info("Notifying action: {}", action);
    observer.update(action, collection);
  }
}
