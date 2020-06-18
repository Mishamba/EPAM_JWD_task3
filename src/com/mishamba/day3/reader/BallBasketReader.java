package com.mishamba.day3.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class BallBasketReader {
    public String[] getBallLines(Path path) {
        try {
            Stream<String> lines = Files.lines(path);
            return (String[]) lines.toArray();
        } catch(IOException ex) {
            System.out.println("can't get any balls");
            throw new RuntimeException();
        }
    }

    public String[] getBasketLines(Path path) {
        try {
            Stream<String> lines = Files.lines(path);
            return (String[]) lines.toArray();
        } catch (IOException ex) {
            System.out.println("can't get any baskets");
            throw new RuntimeException();
        }
    }
}
