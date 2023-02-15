package com.akademi.basket.domain.district.impl;

import com.ismailaga.department.domain.district.api.DistrictDto;
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
@Table(name = District.TABLE)
public class District extends AbstractEntity {
    public static final String TABLE = "district";
    public static final String COL_NAME = "name";
    public static final String COL_CITY_ID = "cityId";
    public static final String COL_DESCRIPTION = "description";

    @Column(name = COL_NAME, nullable = false)
    private String name;

    @Column(name = COL_CITY_ID, nullable = false)
    private String cityId;

    @Column(name = COL_DESCRIPTION, nullable = false)
    private String description;

    public DistrictDto toDto() {
        return DistrictDto.builder().id(this.getId()).created(this.getCreated()).modified(this.getModified()).name(this.name).cityId(this.cityId).description(this.description).build();
    }
}
