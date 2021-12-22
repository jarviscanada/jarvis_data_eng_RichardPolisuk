# Introduction

The grep Java program is a clone of the egrep (Extended Global Regular Exporessions Print) UNIX
command. This command will read all the files in the current directory and every directory below the
current one looking in each file for the regular expression which was passed to be searched. The
output is written to an output file specified as a command argument.

This program is written in Java (using Streams, Lambda, and RegEx pattern matching) with Maven as
the build tool. It is configured to be run as a command line with the JRE installed or via a Docker
container.

# Quick Start

1. Run with JAR file

```
mvn clean package
java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp [regex] [rootDirectory] [outFile]
```

2. Run with Docker

```
docker pull rpolisuk/grep
docker run --rm -v `pwd`/data:/data -v `pwd`/out:/out rpolisuk/grep [regex] [rootDirectory] [outFile]
```

# Implementation

## Pseudocode

```
storedLines = []
for file in listFilesRecursively(rootDir)
  for fileLine in readLines(file)
      if matchesPattern(fileLine)
        storedLines.add(fileLine)
saveToFile(storedLines)
```

## Performance Issue

The issue with this program is that it reads the entire file into memory into an ArrayList.
Therefore, there needs to be enough memory to store this array and then process it. The way this can
be optimized is by using a java.uil.Scanner to process the contents of the file and retrieve lines
serially, one by one. This will reduce the amount of memory needed.

# Test

The program was tested against a complete copy of William Shakespeare's play in one single file. A
string was then used to search this file to ensure it was returned correctly. This was compared with
the egrep command to make sure it matched.

# Deployment

The program was dockerized with a very simple Dockerfile which used the Alpine JDK image, copying
the JAR file (which was produced from a UberJAR file using Maven), and finally configuring the entry
point to execute the Java process with the JAR file. The command line arguments were passed to
configure the Docker container. This was then pushed to DockerHub for easy access.

# Improvements

Three possible improvements can be made to this project:

1. Implement the java.util.Scanner class to process the file as a stream and process each line one at
   a time.
2. Split the file into two parts and process them in parallel.
3. Add an option to add line numbers into the output file so the user will know what line the match
   came from.