package com.gots.cg.controller;

import com.gots.cg.beans.schema.node.N_Movie;
import com.gots.cg.service.neo4j.repositories.IMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final IMovieRepository iMovieRepository;

    @GetMapping
    public Iterable<N_Movie> findAll() {
        return iMovieRepository.findAll();
    }

}
