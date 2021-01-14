package com.gots.cg.beans.schema.node;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Person")
@Data
@EqualsAndHashCode(callSuper = false)
public class NPerson extends NAbstractNode{
    @Property
    private String name;
}
