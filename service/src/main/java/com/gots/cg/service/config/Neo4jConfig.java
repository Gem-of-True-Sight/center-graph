package com.gots.cg.service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Configuration
@EnableNeo4jRepositories("com.gots.cg.service.neo4j.repositories")
@EnableTransactionManagement
public class Neo4jConfig { }
