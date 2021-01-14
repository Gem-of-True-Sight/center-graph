package com.gots.cg.graphql.mappers;

import com.gots.cg.beans.schema.node.NFile;
import com.gots.cg.graphql.model.FileGO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileGOMapper {

    FileGO from(NFile from);

}
