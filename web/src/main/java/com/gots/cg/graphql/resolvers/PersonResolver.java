package com.gots.cg.graphql.resolvers;

import com.gots.cg.graphql.mappers.MovieGOMapper;
import com.gots.cg.graphql.mappers.PersonGOMapper;
import com.gots.cg.graphql.schema.MovieGO;
import com.gots.cg.graphql.schema.PersonGO;
import com.gots.cg.service.neo4j.repositories.IMovieRepository;
import com.gots.cg.service.neo4j.repositories.IPersonRepository;
import io.leangen.graphql.annotations.GraphQLContext;
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
public class PersonResolver {

    private final IPersonRepository iPersonRepository;

    private final PersonGOMapper personGOMapper;

    private final IMovieRepository iMovieRepository;

    private final MovieGOMapper movieGOMapper;

    @GraphQLQuery
    public PersonGO personByName(String name) throws Exception {
        return personGOMapper.from(iPersonRepository.findByName(name));
    }

    @GraphQLQuery
    public List<PersonGO> person() throws Exception {
        return iPersonRepository.findAll().stream().map(personGOMapper::from).collect(Collectors.toList());
    }

    @GraphQLQuery
    public List<MovieGO> actedIn(@GraphQLContext PersonGO personGO) throws Exception {
        log.debug("{}", personGO.getName());
        var res = iMovieRepository.actedIn(personGO.getName());
        return res.stream().map(movieGOMapper::from).collect(Collectors.toList());
    }

}
