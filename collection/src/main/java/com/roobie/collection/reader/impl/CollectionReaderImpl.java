package com.roobie.collection.reader.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.reader.CollectionReader;
import com.roobie.collection.validation.Validator;
import com.roobie.collection.validation.impl.StringValidator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CollectionReaderImpl implements CollectionReader<IntegerCollection> {
  private static final Logger logger = LogManager.getLogger();
  static final String delimiters = "[, \\-\\s]+";

  @Override
  public List<IntegerCollection> parseAllLines(Path filePath) throws IntegerCollectionException {
    if (!Files.exists(filePath)) {
      logger.warn("File does not exist: {}", filePath);
      throw new IntegerCollectionException("Invalid path: " + filePath);
    }
    List<IntegerCollection> data = new ArrayList<>();
    try {
      List<String> lines = Files.readAllLines(filePath);
      for (String line : lines) {
        if (parseIntArray(line) != null) {
          data.add(new IntegerCollection(parseIntArray(line)));
        }
      }
    } catch (IOException e) {
      logger.error(e.getMessage());
      throw new IntegerCollectionException(e.getMessage(), e);
    }
    return data;
  }

  @Override
  public IntegerCollection parseLine(Path filePath, int index) throws IntegerCollectionException {
    if (!Files.exists(filePath)) {
      logger.warn("File does not exist: {}", filePath);
      throw new IntegerCollectionException("Invalid path: " + filePath);
    }
    try {
      List<String> lines = Files.readAllLines(filePath);
      String result = lines.get(index);
      Integer[] arr = parseIntArray(result);
      var collection = new IntegerCollection().builder()
              .collection(arr)
              .build();
      logger.info("Collection read: {}", collection);
      return collection;
    } catch (IOException e) {
      logger.error(e.getMessage());
      throw new IntegerCollectionException(e.getMessage(), e);
    }
  }

  private Integer[] parseIntArray(String input) {
    Validator<String> validator = new StringValidator();
    if (validator.isValid(input)) {
      String[] parts = input.split(delimiters);
      Integer[] arr = new Integer[parts.length];
      for (int i = 0; i < parts.length; i++) {
        arr[i] = Integer.parseInt(parts[i]);
      }
      return arr;
    } else {
      return null;
    }
  }
}
