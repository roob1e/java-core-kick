package com.roobie.collection.observer.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.observer.Observer;
import com.roobie.collection.util.Actions;
import com.roobie.collection.warehouse.Warehouse;

public class RepositoryObserver implements Observer {
  private final Warehouse warehouse;

  public RepositoryObserver(Warehouse warehouse) {
    this.warehouse = warehouse;
  }

  @Override
  public void update(Actions action, IntegerCollection collection) throws IntegerCollectionException {
    switch (action) {
      case CREATE -> warehouse.registerRecord(collection);
      case DELETE -> warehouse.removeRecord(collection);
      case UPDATE -> warehouse.updateRecord(collection);
    }
  }
}
