package com.academy.service.mappers;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Daniel Palonek on 2016-08-18.
 */
public interface Mapper<DAO,DTO> {

    DAO convertToDAO(DTO dto);

    DTO convertToDTO(DAO dao);

    default Iterable<DAO> convertToDAO(Iterable<DTO> dto) {
        return Stream.of(dto).map(this::convertToDAO).collect(Collectors.toList());
    }

    default Iterable<DTO> convertToDTO(Iterable<DAO> dao) {
        return Stream.of(dao).map(this::convertToDTO).collect(Collectors.toList());
    }
}