package com.gots.cg.service.neo4j.repositories;

import com.gots.cg.beans.schema.node.NProject;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends Neo4jRepository<NProject, String> {
}
