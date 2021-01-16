package com.gots.cg.graphql.resolvers.root;

import com.gots.cg.graphql.api.PersonByNameQueryResolver;
import com.gots.cg.graphql.api.PersonQueryResolver;
import com.gots.cg.graphql.mappers.PersonGOMapper;
import com.gots.cg.graphql.model.N_PersonGO;
import com.gots.cg.service.neo4j.repositories.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonResolverImpl
        implements PersonQueryResolver, PersonByNameQueryResolver {

    private final IPersonRepository iPersonRepository;

    private final PersonGOMapper personGOMapper;

    @Override
    public N_PersonGO personByName(String name) throws Exception {
        return personGOMapper.from(iPersonRepository.findByName(name));
    }

    @Override
    public List<N_PersonGO> person() throws Exception {
        return iPersonRepository.findAll().stream().map(personGOMapper::from).collect(Collectors.toList());
    }

}
