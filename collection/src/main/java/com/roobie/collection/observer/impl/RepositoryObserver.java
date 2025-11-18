package com.roobie.collection.observer.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.observer.Observer;
import com.roobie.collection.util.Actions;
import com.roobie.collection.warehouse.impl.WarehouseImpl;

public class RepositoryObserver implements Observer {
  private final WarehouseImpl warehouseImpl;

  public RepositoryObserver(WarehouseImpl warehouseImpl) {
    this.warehouseImpl = warehouseImpl;
  }

  @Override
  public void update(Actions action, IntegerCollection collection) throws IntegerCollectionException {
    switch (action) {
      case CREATE -> warehouseImpl.registerRecord(collection);
      case DELETE -> warehouseImpl.removeRecord(collection);
      case UPDATE -> warehouseImpl.updateRecord(collection);
    }
  }
}
