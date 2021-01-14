package com.gots.cg.graphql.resolvers;

import com.gots.cg.graphql.api.FileQueryResolver;
import com.gots.cg.graphql.mappers.FileGOMapper;
import com.gots.cg.graphql.model.FileGO;
import com.gots.cg.service.neo4j.repositories.IFileRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class FileQueryResolverImpl implements FileQueryResolver {

    private final IFileRepository fileRepository;

    private final FileGOMapper fileGOMapper;

    FileQueryResolverImpl(IFileRepository fileRepository, FileGOMapper fileGOMapper) {
        this.fileGOMapper = fileGOMapper;
        this.fileRepository = fileRepository;
    }

    @Override
    public List<FileGO> file() throws Exception {
        return fileRepository.findAll().stream().map(fileGOMapper::from).collect(toList());
    }

}
