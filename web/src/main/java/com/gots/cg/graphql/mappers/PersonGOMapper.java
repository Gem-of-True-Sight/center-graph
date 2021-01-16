package com.gots.cg.graphql.mappers;

import com.gots.cg.beans.schema.node.N_Person;
import com.gots.cg.graphql.model.N_PersonGO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonGOMapper {

    N_PersonGO from(N_Person from);

}
