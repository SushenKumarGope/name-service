package com.demo.nameService.services;

import com.demo.nameService.requests.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class NameServiceTest {
  @InjectMocks private NameService nameService;

  @BeforeEach
  void setUp() {
    // Initialize @InjectMocks
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testConcatenateWithValidName() {
    Name name = new Name("John", "Cena");
    String result = nameService.concatenate(name);
    assertEquals("John Cena", result);
  }

  @Test
  void testConcatenateWithNameWithSpaces() {
    Name name = new Name("Rock", "Johnson");
    String result = nameService.concatenate(name);
    assertEquals("Rock Johnson", result);
  }

  @Test
  void testConcatenateWithBlankFields() {
    Name name = new Name("", "");
    String result = nameService.concatenate(name);
    assertEquals(" ", result);
  }
}
