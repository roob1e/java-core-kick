package com.roobie.collection.reader;

import com.roobie.collection.entity.IntegerCollection;
import com.roobie.collection.exception.ReaderException;

import java.nio.file.Path;
import java.util.List;

public interface CollectionReader {
  List<IntegerCollection> parseAllLines(Path filePath) throws ReaderException;
  IntegerCollection parseLine(Path filePath, int index) throws ReaderException;
}
