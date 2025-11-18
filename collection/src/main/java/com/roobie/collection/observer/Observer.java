package com.roobie.collection.observer;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.util.Events;

public interface Observer {
  void update(Events action, IntegerCollection collection);
}