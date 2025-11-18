package com.roobie.collection.observer;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.util.Actions;

import java.util.Observable;

public interface Observer {
  void update(Actions action, IntegerCollection collection) throws IntegerCollectionException;
}
