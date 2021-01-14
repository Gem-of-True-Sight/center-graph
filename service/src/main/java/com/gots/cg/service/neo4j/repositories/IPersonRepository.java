package com.gots.cg.service.neo4j.repositories;

import com.gots.cg.beans.schema.node.NPerson;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends Neo4jRepository<NPerson, String> {

    NPerson findByName(String name);
    
}
