package com.gots.cg.service.neo4j.repositories;

import com.gots.cg.beans.schema.node.N_Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends Neo4jRepository<N_Movie, String> {

    @Query("match (n:Person)-[:ACTED_IN]->(m:Movie) where n.name=$name return m")
    List<N_Movie> actedIn(@Param("name")  String name);

}
