package com.example.problem;

import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.rest.StoreRestResource;

import java.util.UUID;

@StoreRestResource(path = "storage")
public interface FileStore extends ContentStore<File, UUID> {
}
