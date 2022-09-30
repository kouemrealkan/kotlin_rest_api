package com.emrealkan.restapiforkotlin.service;

import com.emrealkan.restapiforkotlin.exceptions.AppException;
import com.emrealkan.restapiforkotlin.helper.ImageUtils;
import com.emrealkan.restapiforkotlin.model.ImageData;
import com.emrealkan.restapiforkotlin.model.User;
import com.emrealkan.restapiforkotlin.repository.StorageRepository;
import com.emrealkan.restapiforkotlin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository repository;
    private UserRepository userRepository;

    public StorageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String uploadImage(MultipartFile file,Long userId) throws IOException {

        User user = userRepository.findById(userId).orElseThrow(()->new AppException("user not found"));

        ImageData imageData = (ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .user(user)
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
            repository.save(imageData);
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }

    public byte[] downloadImageByUserId(Long userId){
        Optional<ImageData> dbImageData  =repository.findByUserId(userId);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
