package com.joshuarichardson.musicapi;

import java.io.File;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Joshua on 02/12/2016.
 */
public class Utils {


    public static String artifactId() {
        return UUID.randomUUID().toString();
    }

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

