package com.alloiz.alloizserver.dto;

public interface DtoMapper {
    Object parseFromDTOtoObject(Object dtoObject, Class... parsingClasses);
}
