package com.gots.cg.beans.schema.node;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public abstract class NAbstractNode {

    @Id
    private String bizUUID;

}
