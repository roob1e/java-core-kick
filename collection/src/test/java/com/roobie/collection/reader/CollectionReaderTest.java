package com.roobie.collection.reader;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.ReaderException;
import com.roobie.collection.reader.impl.CollectionReaderImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionReaderTest {
  Path path = Paths.get("data/data.txt");

  @Test
  void parseAllLines() throws ReaderException {
    List<int[]> expected = new ArrayList<>();
    expected.add(new IntegerCollection(new int[]{1, 2, 3, 4}).getCollection());
    expected.add(new IntegerCollection(new int[]{4, 3, 2, 1}).getCollection());
    expected.add(new IntegerCollection(new int[]{8, 1, 4, 6, 8}).getCollection());

    List<IntegerCollection> parsed = new CollectionReaderImpl().parseAllLines(path);
    List<int[]> actual = new ArrayList<>();
    for (IntegerCollection collection : parsed) {
      actual.add(collection.getCollection());
    }

    assertArrayEquals(expected.toArray(), actual.toArray());
  }

  @Test
  void parseLine() throws ReaderException {
    int[] expected = new int[]{1, 2, 3, 4};

    IntegerCollection parsed = new CollectionReaderImpl().parseLine(path, 0);
    int[] actual = parsed.getCollection();

    assertArrayEquals(expected, actual);
  }
}