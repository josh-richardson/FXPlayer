package com.joshuarichardson.musicapi;

import java.io.File;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Joshua on 02/12/2016.
 */
public class Utils {

    private static Random random = new Random();

    public static String artifactId() {
        return IntStream.range(0, 3).mapToObj(i ->  "-" + String.valueOf(random.nextInt(8999) + 1000)).collect(Collectors.joining()).replaceFirst("-", "");
    }

}
