package com.joshuarichardson.musicapi.music_objects;

import com.joshuarichardson.musicapi.Utils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.datatype.Artwork;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author: Joshua Richardson on 16/12/2016.
 */
public class Metadata {

    //encapsulation not needed for these variables



    public String title;
    public String artist;
    public String album;
    public String genre;
    public String description;
    public int year;
    public int trackNumber;

    public int rating = 0;
    public int plays = 0;
    public LocalDateTime dateAdded;



    public Metadata(File file) {
        try {
            AudioFile f = AudioFileIO.read(file);
            Tag tag = f.getTag();

            if ((title = tag.getFirst(FieldKey.TITLE)) != null && StringUtils.isBlank(title)) {
                title = FilenameUtils.removeExtension(file.getName());
            }

            artist = tag.getFirst(FieldKey.ARTIST);
            album = tag.getFirst(FieldKey.ALBUM);
            genre = tag.getFirst(FieldKey.GENRE);
            description = tag.getFirst(FieldKey.COMMENT);
            year = Utils.tryParse(tag.getFirst(FieldKey.YEAR));
            trackNumber = Utils.tryParse(tag.getFirst(FieldKey.TRACK));
            dateAdded = LocalDateTime.now();

            System.out.println(tag.getFirst(FieldKey.ARTIST));
            System.out.println(tag.getFirst(FieldKey.YEAR));
        } catch (CannotReadException | IOException | TagException | InvalidAudioFrameException | ReadOnlyFileException e) {
            e.printStackTrace();
        }
    }
}
