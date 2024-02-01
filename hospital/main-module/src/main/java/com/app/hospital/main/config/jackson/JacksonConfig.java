package com.app.hospital.main.config.jackson;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    //TODO: así no se hace
//    @Primary
//    @Bean
//    public ObjectMapper getModifiedObjectMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(MapperFeature.ALLOW_COERCION_OF_SCALARS, false);
//        mapper.coercionConfigFor(LogicalType.Integer).setCoercion(CoercionInputShape.String, CoercionAction.Fail);
//        mapper.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false);
//
//        return mapper;
//    }

    //TODO: así tampoco
//    @Primary
//    @Bean
//    public ObjectMapper getModifiedObjectMapper() {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        ObjectMapper om = builder
//                .featuresToDisable(MapperFeature.ALLOW_COERCION_OF_SCALARS).build();
//
//        return om;
//    }

    @Bean
    public Module customModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(String.class, new StringOnlyDeserializer());
        return simpleModule;
    }
}
