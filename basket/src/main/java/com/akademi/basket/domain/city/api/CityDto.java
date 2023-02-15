package com.akademi.basket.domain.city.api;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CityDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
    private final String description;

}
