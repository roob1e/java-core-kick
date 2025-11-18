package com.roobie.collection.exception;

import com.roobie.collection.reader.impl.ReaderImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ReaderExceptionTest {
  Path invalid_path = Paths.get("");
  ReaderImpl reader = new ReaderImpl();

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void parseAllLinesException() {
    assertThrows(ReaderException.class, () -> {
      reader.parseAllLines(invalid_path);
    });
  }

  @Test
  void parseLineException() {
    assertThrows(ReaderException.class, () -> {
      reader.parseLine(invalid_path, 1);
    });
  }
}