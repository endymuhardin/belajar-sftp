package com.muhardin.endy.belajar.sftp.service;

import com.muhardin.endy.belajar.sftp.config.SftpConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service @Slf4j
public class FileUploadService {

    @Value("${sftp.directory.local}") private String localFolder;

    @Autowired private SftpConfiguration.UploadGateway uploadGateway;

    public void upload() {
        try (Stream<Path> stream = Files.list(Paths.get(localFolder))) {
            stream.forEach(path -> {
                log.info("Uploading {} ...", path.getFileName());
                uploadGateway.upload(path.toFile());
                log.info("{} upload complete", path.getFileName());
            });
        } catch (Exception err) {
            log.error(err.getMessage(), err);
        }
    }
}
