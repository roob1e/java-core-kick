package com.roobie.collection.exception;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.factory.IntegerCollectionFactory;
import com.roobie.collection.service.impl.IntegerCollectionImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NullCollectionExceptionTest {
  IntegerCollection collection;
  IntegerCollectionImpl impl = new IntegerCollectionImpl();

  @BeforeEach
  void setUp() {
    collection = IntegerCollectionFactory.createEmpty();
  }

  @AfterEach
  void tearDown() {
    collection = null;
  }

  @Test
  void findMinElement() {
    Exception exception = assertThrows(NullCollectionException.class, () -> {
      impl.findMinElement(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }

  @Test
  void findMaxElement() {
    Exception exception = assertThrows(NullCollectionException.class, () -> {
      impl.findMaxElement(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }

  @Test
  void defineAverageValue() {
    Exception exception = assertThrows(NullCollectionException.class, () -> {
      impl.defineAverageValue(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }

  @Test
  void defineSum() {
    Exception exception = assertThrows(NullCollectionException.class, () -> {
      impl.defineSum(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }

  @Test
  void countPositivesAndNegatives() {
    Exception exception = assertThrows(NullCollectionException.class, () -> {
      impl.countPositivesAndNegatives(collection);
    });
    assertEquals("Collection is null", exception.getMessage());
  }
}