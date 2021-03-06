package com.gots.cg.service.neo4j.repositories;

import com.gots.cg.beans.schema.node.N_Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends Neo4jRepository<N_Person, String> {

    @Query("match (n:Person) where n.name=$name return n")
    N_Person findByName(@Param("name")  String name);
}
