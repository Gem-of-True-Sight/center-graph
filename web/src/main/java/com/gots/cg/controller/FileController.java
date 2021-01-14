package com.gots.cg.controller;

import com.gots.cg.beans.schema.node.NFile;
import com.gots.cg.service.neo4j.repositories.IFileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/files")
public class FileController {

    private final IFileRepository iFileRepository;

    public FileController(IFileRepository iFileRepository) {
        this.iFileRepository = iFileRepository;
    }

    @GetMapping
    public Iterable<NFile> findAll() {
        return iFileRepository.findAll();
    }

}
