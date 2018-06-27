package com.alloiz.alloizserver.dto.utils;

public interface DtoMapper {
    Object parseFromDTOtoObject(Object dtoObject, Class... parsingClasses);
}
