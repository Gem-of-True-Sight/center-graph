package com.gots.cg.graphql.mappers;

import com.gots.cg.beans.schema.node.N_Person;
import com.gots.cg.graphql.schema.PersonGO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonGOMapper {

    PersonGO from(N_Person from);

}
