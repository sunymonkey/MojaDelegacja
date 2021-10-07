package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.sunymonkey.mojadelegacja.exceptions.FileStorageException;
import pl.sunymonkey.mojadelegacja.model.DBFile;
import pl.sunymonkey.mojadelegacja.repository.DBFileRepository;
import pl.sunymonkey.mojadelegacja.service.DBFileStorageService;

import java.io.IOException;

@Service
public class DBFileStorageServiceImpl implements DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    @Override
    public DBFile storeFile(MultipartFile file) throws FileStorageException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence ");
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException | FileStorageException ex) {
            throw new FileStorageException("Could not store file  Please try again!");
        }
    }

    @Override
    public DBFile getFile(String fileId) {
        return null;
    }
}
