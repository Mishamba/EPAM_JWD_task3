package com.mishamba.day3.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallBasketReader {
    public List<String> getLines(Path path, String target) {
        if (path == null) {
            throw new RuntimeException("no path");
        }

        try {
            Stream<String> lines = Files.lines(path);
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("can't get data " + target);
            throw new RuntimeException("problems");
        }
    }
}
