package com.roobie.collection.observer;

import com.roobie.collection.util.Events;

public interface Observable<T> {
  void addObservers(Observer... observers);

  void removeObservers(Observer... observers);

  void notifyObservers(Events action, T collection);
}