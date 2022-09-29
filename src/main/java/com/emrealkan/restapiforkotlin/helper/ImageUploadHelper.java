package com.emrealkan.restapiforkotlin.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class ImageUploadHelper {
    public final String UPLOAD_DIR = "C:\\Users\\alkan\\IdeaProjects\\restapiforkotlin\\restapiforkotlin\\src\\main\\resources\\static\\uploads\\images";

    public boolean uploadFile(MultipartFile file){

        boolean f = false;

        try {
          /*  InputStream is = file.getInputStream();
            byte data[] = new byte[is.available()];
            is.read(data);

            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+ File.separator+file.getOriginalFilename());
            fileOutputStream.write(data);
            fileOutputStream.flush();
            fileOutputStream.close();
            f = true;  */

            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
