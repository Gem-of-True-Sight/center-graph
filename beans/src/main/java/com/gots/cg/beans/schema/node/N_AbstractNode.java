package com.gots.cg.beans.schema.node;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public abstract class N_AbstractNode {

    @Id
    private String id;

}
