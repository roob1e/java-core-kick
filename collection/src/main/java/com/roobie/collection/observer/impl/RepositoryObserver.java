package com.roobie.collection.observer.impl;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.observer.Observer;
import com.roobie.collection.repository.impl.IntegerCollectionRepositoryImpl;
import com.roobie.collection.warehouse.Warehouse;

import java.util.Observable;

public class RepositoryObserver {
  private final Warehouse warehouse;

  public RepositoryObserver() {
    this.warehouse = Warehouse.getInstance();
  }

  public void update(Observable object, IntegerCollection collection) {

  }
}
