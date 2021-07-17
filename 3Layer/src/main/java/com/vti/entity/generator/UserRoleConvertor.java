package com.vti.entity.generator;

import javax.persistence.AttributeConverter;


import com.vti.entity.enumerate.EUserRole;

public class UserRoleConvertor implements AttributeConverter<EUserRole, String>{

	@Override
	public String convertToDatabaseColumn(EUserRole role) {
		if(role != null)
		{
			return role.getValue();
		}
		return null;
	}

	@Override
	public EUserRole convertToEntityAttribute(String value) {
		return of(value);
	}
	
	public static EUserRole of(String value) {
		for (EUserRole role : EUserRole.values()) {
			if (role.getValue().equals(value)) {
				return role;
			}
		}
		return null;
	}

}
