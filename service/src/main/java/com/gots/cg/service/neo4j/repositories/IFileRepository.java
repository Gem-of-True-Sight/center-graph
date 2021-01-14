package com.gots.cg.service.neo4j.repositories;

import com.gots.cg.beans.schema.node.NFile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileRepository extends Neo4jRepository<NFile, String> {
}
