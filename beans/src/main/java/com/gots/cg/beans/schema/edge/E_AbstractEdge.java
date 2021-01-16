package com.gots.cg.beans.schema.edge;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@Data
public abstract class E_AbstractEdge<T> {

    private List<String> edges;

    @TargetNode
    private T target;
}
