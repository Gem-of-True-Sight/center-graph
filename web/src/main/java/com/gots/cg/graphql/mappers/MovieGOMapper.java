package com.gots.cg.graphql.mappers;

import com.gots.cg.beans.schema.node.N_Movie;
import com.gots.cg.graphql.model.N_MovieGO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieGOMapper {

    N_MovieGO from(N_Movie from);

}
