package com.gots.cg.graphql.resolvers;

import com.gots.cg.graphql.api.ProjectQueryResolver;
import com.gots.cg.graphql.mappers.ProjectGOMapper;
import com.gots.cg.graphql.model.ProjectGO;
import com.gots.cg.service.neo4j.repositories.IProjectRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ProjectResolverImpl implements ProjectQueryResolver {

    private final IProjectRepository iProjectRepository;

    private final ProjectGOMapper projectGOMapper;

    public ProjectResolverImpl(IProjectRepository iProjectRepository, ProjectGOMapper projectGOMapper) {
        this.iProjectRepository = iProjectRepository;
        this.projectGOMapper = projectGOMapper;
    }

    @Override
    public List<ProjectGO> project() throws Exception {
        return iProjectRepository.findAll().stream().map(projectGOMapper::from).collect(toList());
    }
}
