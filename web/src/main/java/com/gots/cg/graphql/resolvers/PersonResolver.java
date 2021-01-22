package com.gots.cg.graphql.resolvers;

import com.gots.cg.beans.schema.node.N_Person;
import com.gots.cg.beans.schema.olp.OLP_Link;
import com.gots.cg.graphql.mappers.MovieGOMapper;
import com.gots.cg.graphql.mappers.PersonGOMapper;
import com.gots.cg.graphql.pagination.CGPagination;
import com.gots.cg.graphql.schema.MovieGO;
import com.gots.cg.graphql.schema.PersonGO;
import com.gots.cg.service.neo4j.repositories.IMovieRepository;
import com.gots.cg.service.neo4j.repositories.IPersonRepository;
import com.gots.cg.service.neo4j.repositories.olp.OLPRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

  private final OLPRepository olpRepository;

  @GraphQLQuery
  public PersonGO personByName(String name) throws Exception {
    return personGOMapper.from(iPersonRepository.findByName(name));
  }

  @GraphQLQuery
  public CGPagination<N_Person> person(
      @GraphQLArgument(name = "first") int first, @GraphQLArgument(name = "offset") int offset)
      throws Exception {
    Page<N_Person> books = iPersonRepository.findAll(PageRequest.of(first, offset));
    return CGPagination.create(books.getContent(), books.getTotalElements(), offset);
  }

  @GraphQLQuery
  public List<OLP_Link> match(@GraphQLArgument(name = "link") OLP_Link link)
      throws Exception {
    return olpRepository.query(link);
  }

  @GraphQLQuery
  public List<MovieGO> actedIn(@GraphQLContext PersonGO personGO) throws Exception {
    log.debug("{}", personGO.getName());
    var res = iMovieRepository.actedIn(personGO.getName());
    return res.stream().map(movieGOMapper::from).collect(Collectors.toList());
  }
}
