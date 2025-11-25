package com.roobie.collection.parser.impl;

import com.roobie.collection.validation.Validator;
import com.roobie.collection.validation.impl.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class StreamCollectionParser {
  private static final String delimiters = "[, \\-\\s]+";
  private final Validator<String> validator = new StringValidator();
  private static final Logger logger = LogManager.getLogger();

  public static Integer[] parse(String input) {
    Integer[] array = Arrays.stream(input.split(delimiters))
            .map(String::trim)
            .map(Integer::parseInt)
            .toArray(Integer[]::new);
    logger.info("Parsed a line to collection: {}", Arrays.toString(array));
    return array;
  }
}
