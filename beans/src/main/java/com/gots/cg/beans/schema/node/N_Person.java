package com.gots.cg.beans.schema.node;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Person")
@Data
@EqualsAndHashCode(callSuper = true)
public class N_Person extends N_AbstractNode {

    @Property
    private String name;

    @Property
    private Integer born;

//    @Relationship(value = "ACTED_IN", direction = Relationship.Direction.OUTGOING)
//    private Set<N_Movie> actedIn;
//
//    @Relationship(value = "REVIEWED", direction = Relationship.Direction.OUTGOING)
//    private Set<N_Movie> reviewed;
//
//    @Relationship(value = "PRODUCED", direction = Relationship.Direction.OUTGOING)
//    private Set<N_Movie> produced;
//
//    @Relationship(value = "WROTE", direction = Relationship.Direction.OUTGOING)
//    private Set<N_Movie> wrote;
//
//    @Relationship(value = "DIRECTED", direction = Relationship.Direction.OUTGOING)
//    private Set<N_Movie> directed;
//
//    @Relationship(value = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
//    private Set<N_Movie> follows;
//
//    @Relationship(value = "FOLLOWS", direction = Relationship.Direction.INCOMING)
//    private Set<N_Movie> beFollows;

}


