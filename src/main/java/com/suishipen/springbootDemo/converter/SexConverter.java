package com.suishipen.springbootDemo.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.suishipen.springbootDemo.enums.Sex;

@Converter
public class SexConverter implements AttributeConverter<Integer, Sex> {
	@Override
	public Sex convertToDatabaseColumn(Integer value) {
		if (value == null) {
            value = 0;
        }

        return Sex.fromCode(value);
	}

	@Override
	public Integer convertToEntityAttribute(Sex value) {
		if (value == null) {
            return 0;
        }

        return value.getCode();
	}
}
