package com.mishamba.day3.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class BallBasketReader {
    public String[] getBallLines(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return (String[]) lines.toArray();
        }
    }

    public String[] getBasketLines(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return (String[]) lines.toArray();
        }
    }
}
