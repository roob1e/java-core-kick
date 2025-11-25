package com.roobie.collection.reader.impl;

import com.roobie.collection.entity.impl.IntegerCollection;
import com.roobie.collection.exception.IntegerCollectionException;
import com.roobie.collection.parser.impl.StreamCollectionParser;
import com.roobie.collection.reader.CollectionReader;
import com.roobie.collection.validation.Validator;
import com.roobie.collection.validation.impl.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class StreamCollectionReaderImpl implements CollectionReader<IntegerCollection> {
  private static final String delimiters = "[, \\-\\s]+";
  private static final Logger logger = LogManager.getLogger();
  private final StreamCollectionParser parser = new StreamCollectionParser();

  @Override
  public List<IntegerCollection> readAllLines(Path filePath) throws IntegerCollectionException {
    Validator<String> validator = new StringValidator();
    if (!Files.exists(filePath)) {
      logger.warn("File does not exist: {}", filePath);
      throw new IntegerCollectionException("Invalid path: " + filePath);
    }
    try (Stream<String> stream = Files.lines(filePath)) {
      logger.info("Parsing file: {}", filePath.toAbsolutePath());
       return stream
               .filter(validator::isValid)
               .map(StreamCollectionParser::parse)
               .map(IntegerCollection::new)
               .toList();
    } catch (IOException e) {
      logger.error("Error parsing file: {}, {}", filePath.toAbsolutePath(), e.getMessage());
      throw new IntegerCollectionException("File not found");
    }
  }

  @Override
  public IntegerCollection readLine(Path filePath, int line) throws IntegerCollectionException {
    Validator<String> validator = new StringValidator();
    if (!Files.exists(filePath)) {
      logger.warn("File does not exist: {}", filePath);
      throw new IntegerCollectionException("Invalid path: " + filePath);
    }
    try (Stream<String> lines = Files.lines(filePath)) {
      logger.info("Parsing file: {}", filePath.toAbsolutePath());
      return lines
              .skip(line)
              .findFirst()
              .filter(validator::isValid)
              .map(StreamCollectionParser::parse)
              .map(IntegerCollection::new)
              .orElseThrow(() ->
                      new IntegerCollectionException("File not found or invalid line: " + filePath.toAbsolutePath()));
    } catch (IOException e) {
      logger.error("Error parsing file: {}, {}", filePath.toAbsolutePath(), e.getMessage());
      throw new IntegerCollectionException("File not found");
    }
  }
}