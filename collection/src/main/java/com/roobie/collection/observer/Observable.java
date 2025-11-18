package com.roobie.collection.observer;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.util.Events;

public interface Observable {
  void addObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers(Events action, IntegerCollection collection) throws IntegerCollectionException;
}
