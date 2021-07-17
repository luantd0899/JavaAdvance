package com.vti.entity.generator;

import javax.persistence.AttributeConverter;

import com.vti.entity.enumerate.EUserGender;

public class UserGenderConvertor implements AttributeConverter<EUserGender, String>  {

	@Override
	public String convertToDatabaseColumn(EUserGender gender) {
		if (gender != null) {
			return gender.getValue();
		}
		return null;
	}

	@Override
	public EUserGender convertToEntityAttribute(String value) {
		
		return of(value);
	}
	
	public static EUserGender of(String value) {
		for (EUserGender gender : EUserGender.values()) {
			if (gender.getValue().equals(value)) {
				return gender;
			}
		}
		
		return null;
	}
	
}
