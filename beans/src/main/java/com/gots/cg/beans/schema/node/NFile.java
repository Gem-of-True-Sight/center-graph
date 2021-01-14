package com.gots.cg.beans.schema.node;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("File")
@Data
@EqualsAndHashCode(callSuper = false)
public class NFile extends NAbstractNode{
    @Property
    private String name;
}
