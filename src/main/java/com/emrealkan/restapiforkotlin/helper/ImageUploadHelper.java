package com.emrealkan.restapiforkotlin.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class ImageUploadHelper {
   // public final String UPLOAD_DIR = "C:\\Users\\alkan\\IdeaProjects\\restapiforkotlin\\restapiforkotlin\\src\\main\\resources\\static\\uploads\\images";

    private final String uploadLocation;

   // public final String UPLOAD_DIR = new ClassPathResource("static/uploads/images").getFile().getAbsolutePath();

    public ImageUploadHelper(@Value("${upload.location}") String uploadLocation) throws IOException
    {
           this.uploadLocation = uploadLocation;
           Path uploadPath = Paths.get(uploadLocation);
           if(!Files.exists(uploadPath)){
               Files.createDirectory(uploadPath);
           }
    }

    public boolean uploadFile(MultipartFile file){

        String fileName = file.getOriginalFilename();
        Path dest = Paths.get(uploadLocation + "/" + fileName);

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

            System.out.println("zaaaa xD" + dest.toFile().getAbsolutePath());
           // System.out.println("directory 1 :" + UPLOAD_DIR);
            Files.copy(file.getInputStream(), dest, StandardCopyOption.REPLACE_EXISTING);
           // System.out.println("directory 2 :" + UPLOAD_DIR);
            f = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
