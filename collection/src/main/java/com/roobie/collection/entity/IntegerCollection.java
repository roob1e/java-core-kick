package com.roobie.collection.entity;

public class IntegerCollection {
  private int[] collection;

  public IntegerCollection(int[] collection) {
    this.collection = collection;
  }

  public IntegerCollection() {}

  private IntegerCollection(Builder builder) {
    this.collection = builder.collection;
  }

  public int[] getCollection() {
    return this.collection;
  }

  public void setCollection(int[] collection) {
    this.collection = collection;
  }

  public Builder builder() {
    return new Builder();
  }

  public class Builder {
    private int[] collection;

    public Builder collection(int[] collection) {
      this.collection = collection;
      return this;
    }

    public IntegerCollection build() {
      return new IntegerCollection(this);
    }
  }
}
