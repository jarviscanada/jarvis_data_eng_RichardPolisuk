package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class LetterWithNumberTest {

  private LetterWithNumber lwnt;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));

    lwnt = new LetterWithNumber();
  }

  @After
  public void cleanUpStreams() {
    // Restore back to console
    System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.out)));
  }

  @Test
  public void printLetterWithNumber() {
    lwnt.PrintLetterWithNumber("AbceE");

    String expected = "input: AbceE\noutput: A27b2c3e5E31"
        .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));

    assertEquals(expected,
        outContent.toString().trim());
  }
}