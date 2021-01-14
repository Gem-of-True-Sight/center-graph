package com.gots.cg.graphql.resolvers;

import com.gots.cg.graphql.api.PersonByNameQueryResolver;
import com.gots.cg.graphql.api.PersonQueryResolver;
import com.gots.cg.graphql.mappers.PersonGOMapper;
import com.gots.cg.graphql.model.PersonGO;
import com.gots.cg.service.neo4j.repositories.IPersonRepository;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class PersonResolverImpl
        implements PersonQueryResolver, PersonByNameQueryResolver {

    private final IPersonRepository iPersonRepository;

    private final PersonGOMapper personGOMapper;

    public PersonResolverImpl(IPersonRepository iPersonRepository, PersonGOMapper personGOMapper) {
        this.iPersonRepository = iPersonRepository;
        this.personGOMapper = personGOMapper;
    }

    @Override
    public List<PersonGO> person() throws Exception {
        return iPersonRepository.findAll().stream().map(personGOMapper::from).collect(toList());
    }

    @Override
    public @NotNull PersonGO personByName(String name) throws Exception {
        return personGOMapper.from(iPersonRepository.findByName(name));
    }
}
