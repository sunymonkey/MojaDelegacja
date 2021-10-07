package pl.sunymonkey.mojadelegacja.service;

import org.springframework.web.multipart.MultipartFile;
import pl.sunymonkey.mojadelegacja.exceptions.FileStorageException;
import pl.sunymonkey.mojadelegacja.model.DBFile;

public interface DBFileStorageService {
    DBFile storeFile(MultipartFile file) throws FileStorageException;
    DBFile getFile(String fileId);
}
