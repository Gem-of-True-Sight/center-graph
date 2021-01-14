package com.gots.cg.graphql.mappers;

import com.gots.cg.beans.schema.node.NProject;
import com.gots.cg.graphql.model.ProjectGO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectGOMapper {

    ProjectGO from(NProject from);

}
