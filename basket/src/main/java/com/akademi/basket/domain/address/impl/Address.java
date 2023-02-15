package com.akademi.basket.domain.address.impl;

import com.ismailaga.department.domain.address.api.AddressDto;
import com.ismailaga.department.domain.city.impl.City;
import com.ismailaga.department.domain.district.impl.District;
import com.ismailaga.department.library.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Address.TABLE)
public class Address extends AbstractEntity {
    public static final String TABLE = "address";
    public static final String COL_CITY_ID = "cityId";
    public static final String COL_DISTRICT_ID = "districtId";
    public static final String COL_FULL_ADDRESS = "fullAddress";

    @Column(name = COL_FULL_ADDRESS, nullable = false)
    private String fullAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = COL_CITY_ID)
    private City city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = COL_DISTRICT_ID)
    private District district;

    public AddressDto toDto() {
        return AddressDto.builder().id(this.getId()).created(this.getCreated()).modified(this.getModified()).fullAddress(this.fullAddress).build();
    }
}
