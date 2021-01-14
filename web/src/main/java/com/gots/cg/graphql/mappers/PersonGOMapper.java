package com.gots.cg.graphql.mappers;

import com.gots.cg.beans.schema.node.NPerson;
import com.gots.cg.graphql.model.PersonGO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonGOMapper {

    PersonGO from(NPerson from);

}
