package ca.jrvs.apps.grep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaGrepImp implements JavaGrep {

  final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

  private String regex;
  private String rootPath;
  private String outFile;

  public static void main(String[] args) throws IllegalAccessException {
    if (args.length != 3) {
      throw new IllegalAccessException("USAGE: JavaGrep regex rootPath outFile");
    }

    BasicConfigurator.configure(); // Use default logger config

    JavaGrepImp javaGrepImp = new JavaGrepImp();

    // Display the arguments
    javaGrepImp.logger.debug(
        "Command arguments: " + args[0] + " " + args[1] + " " + args[2]);

    // Store the arguments
    javaGrepImp.setRegex(args[0]);
    javaGrepImp.setRootPath(args[1]);
    javaGrepImp.setOutFile(args[2]);

    try {
      javaGrepImp.process();
    } catch (Exception ex) {
      javaGrepImp.logger.error("Error: Unable to process ", ex);
    }
  }

  /**
   * Top level search workflow
   *
   * @throws IOException Illegal IO exception
   */
  @Override
  public void process() throws IOException {

    List<File> files = listFiles(this.rootPath);
    List<String> lines;
    List<String> matchedLines = new ArrayList<>();

    if (files != null) { // Process the files as long as there some to process
      for (File file : files) {
        lines = this.readLines(file);
        if (lines != null) { // Process the lines as long as they were read
          for (String line : lines) {
            if (this.containsPattern(line)) { // Save the matches
              matchedLines.add(line);
            }
          }
        }
      }
      if (matchedLines.size() > 0) { // If there are any matches, save to file
        try {
          this.writeToFile(matchedLines);
        } catch (Exception e) {
          throw new IOException("Unable to write file to disk.");
        }
      }
    } else {
      logger.error("No matches found.");
    }
  }

  /**
   * Traverse a given directory and return all files
   *
   * @param rootDir input directory
   * @return files under the rootDir
   */
  @Override
  public List<File> listFiles(String rootDir) {
    List<File> files = new ArrayList<>(); // Initialize the return list
    try {
      // Walk the file root getting all the objects (including directories)
      Files.walk(Paths.get(rootDir)).forEach(item -> {
        if (item.toFile().isFile()) {
          files.add(item.toFile()); // Add the file to return
        }
      });
    } catch (IOException e) {
      return null; // Return null if problem
    }
    return files;
  }

  /**
   * Read a file and return all the lines
   * <p>
   * Explain FileReader, BufferedReader, and character encoding
   *
   * @param inputFile file to be read
   * @return lines
   */
  @Override
  public List<String> readLines(File inputFile) {

    BufferedReader reader = null;
    String line;
    List<String> lines = new ArrayList<>(); // Initialize the return list

    try {
      reader = Files.newBufferedReader(inputFile.toPath());
      while ((line = reader.readLine()) != null) {
        lines.add(line);
      }
    } catch (Exception e) {
      return null; // Return null if problem
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return lines;
  }

  /**
   * check if a line contains the regex pattern (passed by user)
   *
   * @param line input string
   * @return true if there is a match
   */
  @Override
  public boolean containsPattern(String line) {
    Pattern pattern = Pattern.compile(this.getRegex());
    Matcher matcher = pattern.matcher(line);
    return matcher.find();
  }

  /**
   * Write lines to a file
   * <p>
   * Explore: FileOutputStream, OutputStreamWriter, and BufferedWriter
   *
   * @param lines matched line
   * @throws IOException if write failed
   */
  @Override
  public void writeToFile(List<String> lines) throws IOException {
    FileWriter outFile = new FileWriter(this.getOutFile());
    BufferedWriter outStream = new BufferedWriter(outFile);
    for (String line : lines) {
      outStream.write(line);
      outStream.newLine();
    }
    outStream.close();
    logger.debug("File successfully written to disk.");
  }

  /**
   * Gets root path
   *
   * @return Root path
   */
  @Override
  public String getRootPath() {
    return this.rootPath;
  }

  /**
   * Sets root path
   *
   * @param rootPath Root path
   */
  @Override
  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  /**
   * Getter
   *
   * @return Regular expression
   */
  @Override
  public String getRegex() {
    return this.regex;
  }

  /**
   * Sets RegEx expression
   *
   * @param regex Regular expression
   */
  @Override
  public void setRegex(String regex) {
    this.regex = regex;
  }

  /**
   * Gets output file name
   *
   * @return output file
   */
  @Override
  public String getOutFile() {
    return this.outFile;
  }

  /**
   * Sets output file name
   *
   * @param outFile Output file
   */
  @Override
  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }
}
