package com.joshuarichardson.musicapi.resource;

import javafx.scene.image.Image;
import javafx.util.Pair;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Joshua on 02/12/2016.
 */
public class ImageResourceManager {

    HashMap<String, ImgRef> images;
    String relativePath;
    Class c;

    public ImageResourceManager(Class c, String relativePath, ImgRef... imageDetails) {
        images = new HashMap<>();
        Arrays.stream(imageDetails).forEach(i -> images.put(FilenameUtils.removeExtension(i.getFileName()), new ImgRef(new Image(c.getResourceAsStream(relativePath + File.separator + i.getFileName())), i.getXShift())));
        this.relativePath = relativePath;
        this.c = c;
    }

    public ImgRef get(String key) {
        return images.getOrDefault(key, null);
    }

    public void add(Pair<String, Integer>... imageDetails) {
        Arrays.stream(imageDetails).forEach(i -> images.put(FilenameUtils.removeExtension(i.getKey()), new ImgRef(new Image(c.getResourceAsStream(relativePath + File.separator + i)), i.getValue())));
    }

    public void dispose() {
        images = null;
        relativePath = null;
    }
}
