package com.demo.project.documentation;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Base64;
@UtilityClass
public class ImageEncoder {
    public static String encodeImageToBase64(String fileNameOrPath) {
        try {
            File image = Paths.get(ImageEncoder.class.getClassLoader().getResource(fileNameOrPath).toURI()).toFile();
            byte[] fileContent = FileUtils.readFileToByteArray(image);
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("There is something wrong with image");
        }
    }

}
