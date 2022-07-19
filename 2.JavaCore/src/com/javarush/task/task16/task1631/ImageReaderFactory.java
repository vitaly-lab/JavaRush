package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type) {

      //  ImageReader toReturn = null;

        if (ImageTypes.PNG == type) {
            return new PngReader();
        } else if (ImageTypes.JPG == type) {
            return new JpgReader();
        } else if (ImageTypes.BMP == type) {
            return new BmpReader();
        }

        throw new IllegalArgumentException("Неизвестный тип картинки");

    }


}
