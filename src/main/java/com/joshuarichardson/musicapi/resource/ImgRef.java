package com.joshuarichardson.musicapi.resource;

import javafx.scene.image.Image;

/**
 * @author: Joshua Richardson on 02/12/2016.
 */
public class ImgRef {
    private Image image;
    private int xShift;
    private String fileName;

    public ImgRef(Image image, int xShift) {
        this.image = image;
        this.xShift = xShift;
    }

    public ImgRef(String fileName, int xShift) {
        this.fileName = fileName;
        this.xShift = xShift;
    }

    public Image getImage() {
        return image;
    }

    public int getXShift() {
        return xShift;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getFileName() {
        return fileName;
    }
}
