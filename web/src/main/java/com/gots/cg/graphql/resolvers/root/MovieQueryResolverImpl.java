package com.gots.cg.graphql.resolvers.root;

import com.gots.cg.graphql.api.MovieQueryResolver;
import com.gots.cg.graphql.mappers.MovieGOMapper;
import com.gots.cg.graphql.model.N_MovieGO;
import com.gots.cg.service.neo4j.repositories.IMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j(topic = "gots")
@Component
@RequiredArgsConstructor
public class MovieQueryResolverImpl implements MovieQueryResolver {

    private final IMovieRepository iMovieRepository;

    private final MovieGOMapper movieGOMapper;

    @Override
    public List<N_MovieGO> movie() throws Exception {
        return iMovieRepository.findAll().stream().map(movieGOMapper::from).collect(Collectors.toList());
    }
}
