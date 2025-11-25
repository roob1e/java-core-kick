package com.roobie.collection.reader;

import java.nio.file.Path;
import java.util.List;

public interface CollectionReader<T> {
  List<T> parseAllLines(Path filePath) throws Throwable;
  T parseLine(Path filePath, int index) throws Throwable;
}
