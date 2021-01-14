package com.gots.cg.graphql.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfiguration {


    @Bean
    public GraphQLScalarType extendedScalarsDateTime() {
        return ExtendedScalars.DateTime;
    }

    @Bean
    public GraphQLScalarType extendedScalarsDate() {
        return ExtendedScalars.Date;
    }

    @Bean
    public GraphQLScalarType extendedScalarsBigDecimal() {
        return ExtendedScalars.GraphQLBigDecimal;
    }

}