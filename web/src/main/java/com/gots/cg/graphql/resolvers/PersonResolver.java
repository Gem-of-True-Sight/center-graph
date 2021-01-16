package com.gots.cg.graphql.resolvers;

import com.gots.cg.graphql.mappers.MovieGOMapper;
import com.gots.cg.graphql.model.N_MovieGO;
import com.gots.cg.graphql.model.N_PersonGO;
import com.gots.cg.service.neo4j.repositories.IMovieRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonResolver implements GraphQLResolver<N_PersonGO> {

    private final IMovieRepository iMovieRepository;

    private final MovieGOMapper movieGOMapper;

    public List<N_MovieGO> actedIn(N_PersonGO personGO) throws Exception {
        var res = iMovieRepository.actedIn(personGO.getName());
        return res.stream().map(movieGOMapper::from).collect(Collectors.toList());
    }

}
