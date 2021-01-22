package com.gots.cg.beans.schema.node;

import com.gots.cg.beans.schema.edge.E_ActedIn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Node("Movie")
@Data
@EqualsAndHashCode(callSuper = true)
public class N_Movie extends N_AbstractNode {
    @Property
    private String tagline;

    @Property
    private String title;

    @Property
    private Integer released;

    @Relationship(value = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private Set<E_ActedIn> actedIn;

    @Relationship(value = "REVIEWED", direction = Relationship.Direction.INCOMING)
    private Set<N_Person> reviewed;

    @Relationship(value = "PRODUCED", direction = Relationship.Direction.INCOMING)
    private Set<N_Person> produced;

    @Relationship(value = "WROTE", direction = Relationship.Direction.INCOMING)
    private Set<N_Person> wrote;

    @Relationship(value = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private Set<N_Person> directed;

}
