package com.example.problem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@SpringBootApplication
@RestController
@RequestMapping("/files")
@Slf4j
public class ProblemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProblemApplication.class, args);
    }

    @Autowired
    FileStore store;
    @Autowired
    FileRepository repository;

    @PostMapping
    public UUID create(@RequestParam("file") MultipartFile multipartFile) {
        File file = new File();
        file.setMimeType(multipartFile.getContentType());
        store.setContent(file, multipartFile.getResource());
        UUID id = repository.save(file).getId();
        log.info("id {}", id);
        return id;
    }


}
