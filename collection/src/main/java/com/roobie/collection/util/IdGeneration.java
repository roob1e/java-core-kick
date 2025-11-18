package com.roobie.collection.util;

public class IdGeneration {
  private static long id = 0;

  public static long next() {
    id++;
    return id;
  }
}