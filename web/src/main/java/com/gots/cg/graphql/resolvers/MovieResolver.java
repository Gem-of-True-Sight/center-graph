package com.gots.cg.graphql.resolvers;

import com.gots.cg.graphql.mappers.MovieGOMapper;
import com.gots.cg.graphql.schema.MovieGO;
import com.gots.cg.service.neo4j.repositories.IMovieRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j(topic = "gots")
@Component
@RequiredArgsConstructor
@GraphQLApi
public class MovieResolver {

    private final IMovieRepository iMovieRepository;

    private final MovieGOMapper movieGOMapper;

    @GraphQLQuery
    public List<MovieGO> movie() throws Exception {
        return iMovieRepository.findAll().stream().map(movieGOMapper::from).collect(Collectors.toList());
    }

}
