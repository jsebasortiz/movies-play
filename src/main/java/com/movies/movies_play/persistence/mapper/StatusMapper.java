package com.movies.movies_play.persistence.mapper;

import org.mapstruct.Named;

public class StatusMapper {
    @Named("stringToBoolean")
    public static Boolean stringToBoolean(String status) {
        if (status == null) return null;

        return switch (status.toUpperCase()) {
            case "D" -> true;
            case "N" -> false;
            default -> null;
        };
    }

    @Named("booleanToString")
    public static String booleanToString(Boolean status) {
        if (status == null) return null;

        return status ? "D" : "N";
    }


}
