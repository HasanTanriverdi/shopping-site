package com.akademi.basket.domain.city.impl;

import com.ismailaga.department.domain.city.api.CityDto;
import com.ismailaga.department.library.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = City.TABLE)
public class City extends AbstractEntity {
    public static final String TABLE = "city";
    public static final String COL_NAME = "name";
    public static final String COL_DESCRIPTION = "description";

    @Column(name = COL_NAME, nullable = false)
    private String name;

    @Column(name = COL_DESCRIPTION, nullable = false)
    private String description;

    public CityDto toDto() {
        return CityDto.builder().id(this.getId()).created(this.getCreated()).modified(this.getModified()).name(this.name).description(this.description).build();
    }
}
