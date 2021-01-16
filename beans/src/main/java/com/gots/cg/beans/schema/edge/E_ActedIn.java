package com.gots.cg.beans.schema.edge;

import com.gots.cg.beans.schema.node.N_Movie;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

@Data
@EqualsAndHashCode(callSuper = true)
@RelationshipProperties
public class E_ActedIn extends E_AbstractEdge<N_Movie>{

}
