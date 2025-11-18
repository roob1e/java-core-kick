package com.roobie.collection;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.ReaderException;
import com.roobie.collection.reader.impl.ReaderImpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class main {
  public static void main(String[] args) throws ReaderException {
    IntegerCollection collection;
    Path path = Paths.get("data.txt");
    System.out.println(path.toAbsolutePath());
    List<IntegerCollection> result = new ReaderImpl().parseAllLines(path);
    System.out.println(result.toString());
  }
}
