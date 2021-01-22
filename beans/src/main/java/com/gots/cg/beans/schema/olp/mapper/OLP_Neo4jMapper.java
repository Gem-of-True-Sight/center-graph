package com.gots.cg.beans.schema.olp.mapper;

import com.gots.cg.beans.schema.olp.OLP_Link;
import com.gots.cg.beans.schema.olp.OLP_Node;
import org.mapstruct.Mapper;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Relationship;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/21 16:08
 */
@Mapper(componentModel = "spring")
public interface OLP_Neo4jMapper {

  default OLP_Node node(Node from) {
    OLP_Node node = new OLP_Node();
//    node.setId(from.id());
    node.setType(from.labels().iterator().next());
    node.setLabels(StreamSupport.stream(from.labels().spliterator(), false).collect(Collectors.toSet()));
    node.setProperties(from.asMap());
    return node;
  }

  default OLP_Link link(Relationship from, String type) {

    OLP_Link link = new OLP_Link();

//    link.setId(from.id());
    link.setType(type);
    link.setProperties(from.asMap());

    OLP_Node start = new OLP_Node();
//    start.setId(from.startNodeId());
    link.setSource(start);

    OLP_Node target = new OLP_Node();
//    target.setId(from.endNodeId());
    link.setTarget(target);

    return link;
  }
}
