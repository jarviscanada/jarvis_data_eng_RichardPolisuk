package ca.jrvs.apps.grep;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.BasicConfigurator;

public class JavaGrepLambdaImp extends JavaGrepImp {

  public static void main(String[] args) throws IllegalAccessException {
    if (args.length != 3) {
      throw new IllegalAccessException("USAGE: JavaGrep regex rootPath outFile");
    }

    BasicConfigurator.configure(); // Use default logger config

    JavaGrepLambdaImp jl = new JavaGrepLambdaImp();

    // Store the arguments
    jl.setRegex(args[0]);
    jl.setRootPath(args[1]);
    jl.setOutFile(args[2]);

    try {
      jl.process();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
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
    List<String> result;
    try (Stream<String> lines = Files.lines(Paths.get(String.valueOf(inputFile)))) {
      result = lines.collect(Collectors.toList());
    } catch (Exception e) {
      result = null;
    }
    return result;
  }

  /**
   * Traverse a given directory and return all files
   *
   * @param rootDir input directory
   * @return files under the rootDir
   */
  @Override
  public List<File> listFiles(String rootDir) {
    List<File> result;
    try (Stream<Path> walk = Files.walk(Paths.get(rootDir))) {
      result = walk
          .filter(Files::isRegularFile)
          .map(Path::toFile)
          .collect(Collectors.toList());
    } catch (Exception e) {
      result = null;
    }
    return result;
  }

}
