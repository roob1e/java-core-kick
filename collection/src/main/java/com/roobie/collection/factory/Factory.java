package com.roobie.collection.factory;

import com.roobie.collection.observer.Observer;

public interface Factory<T, U> {
  T createEmpty();
  T createRandom(int size);
  T createFromArray(U[] array);
  T createFull(U[] array, Observer... observers);
  T createFullRandom(int size, Observer... observers);
}