package com.pablobuendia.universitymanager.address.city;

import com.pablobuendia.universitymanager.address.country.CountryDto;
import com.pablobuendia.universitymanager.address.country.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City cityToCityDto(CityDto cityDto);
    CityDto cityDtoToCity(City city);

    Country cityToCityDto(CountryDto cityDto);
    CountryDto cityDtoToCity(Country city);
}
