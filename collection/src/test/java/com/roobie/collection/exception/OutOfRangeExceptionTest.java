package com.roobie.collection.exception;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.factory.IntegerCollectionFactory;
import com.roobie.collection.service.impl.IntegerCollectionImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutOfRangeExceptionTest {
  IntegerCollection collection;
  IntegerCollectionImpl impl = new IntegerCollectionImpl();

  @BeforeEach
  void setUp() {
    collection = IntegerCollectionFactory.createRandom(5);
  }

  @AfterEach
  void tearDown() {
    collection = null;
  }

  @Test
  void replaceElement() {
    int value = 0;
    int index = 5;
    Exception exception = assertThrows(IndexOutOfRangeException.class, () -> {
      impl.replaceElement(collection, value, index);
    });
    assertEquals("Index out of range", exception.getMessage());
  }
}