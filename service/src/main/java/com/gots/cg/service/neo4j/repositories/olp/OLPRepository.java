package com.gots.cg.service.neo4j.repositories.olp;

import com.gots.cg.beans.schema.olp.OLP_Link;
import com.gots.cg.beans.schema.olp.OLP_Node;
import com.gots.cg.beans.schema.olp.mapper.OLP_Neo4jMapper;
import com.gots.cg.core.BeanFieldLambda;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.cypherdsl.core.Cypher;
import org.neo4j.cypherdsl.core.renderer.Renderer;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.TypeSystem;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/21 12:55
 */
@Slf4j(topic = "gots")
@Repository
public class OLPRepository {

  private final Neo4jClient neo4jClient;

  private final OLP_Neo4jMapper olp_Neo4JMapper;

  private static final Renderer renderer = Renderer.getDefaultRenderer();

  public OLPRepository(Neo4jClient neo4jClient, OLP_Neo4jMapper olp_Neo4JMapper) {
    this.neo4jClient = neo4jClient;
    this.olp_Neo4JMapper = olp_Neo4JMapper;
  }

  public List<OLP_Link> query(OLP_Link link) throws Exception {

    var sourceName = BeanFieldLambda.field(OLP_Link::getSource);
    var targetName = BeanFieldLambda.field(OLP_Link::getTarget);
    var linkName = "links";

    var sourceNode =
        Optional.of(
                Optional.ofNullable(
                        Optional.ofNullable(link.getSource()).orElse(new OLP_Node()).getType())
                    .map(
                        s ->
                            Cypher.node(s)
                                .named(sourceName)
                                .withProperties("name", Cypher.literalOf("Charlize Theron")))
                    .orElse(Cypher.anyNode().named(sourceName)))
            .get();

    var targetNode =
        Optional.of(
                Optional.ofNullable(
                        Optional.ofNullable(link.getTarget()).orElse(new OLP_Node()).getType())
                    .map(s -> Cypher.node(s).named(targetName))
                    .orElse(Cypher.anyNode().named(targetName)))
            .get();

    var relatedTo = sourceNode.relationshipBetween(targetNode, link.getType()).named(linkName);

    var statement = Cypher.match(relatedTo).returning(sourceNode, relatedTo, targetNode).build();

    var cql = renderer.render(statement);

    log.debug("OLP QUERY: {}", cql);

    var res =
        neo4jClient
            .query(cql)
            .fetchAs(OLP_Link.class)
            .mappedBy(
                (TypeSystem t, Record record) -> {
                  var sourceRes =
                      olp_Neo4JMapper.node(
                          record.get(sourceName).asNode());
                  var targetRes =
                      olp_Neo4JMapper.node(
                          record.get(targetName).asNode());
                  var linkRes =
                      olp_Neo4JMapper.link(record.get(linkName).asRelationship(), link.getType());
                  linkRes.setSource(sourceRes);
                  linkRes.setTarget(targetRes);

                  log.debug("{}", record);
                  return linkRes;
                })
            .all();

    log.debug("{}", res.size());

    return new ArrayList<>(res);
  }
}
