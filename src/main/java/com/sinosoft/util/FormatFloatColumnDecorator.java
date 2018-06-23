package com.sinosoft.util;

import org.displaytag.decorator.ColumnDecorator;
import org.displaytag.exception.DecoratorException;

public class FormatFloatColumnDecorator implements ColumnDecorator {

	@Override
	public String decorate(Object columnValue) throws DecoratorException {
		if(columnValue == null || columnValue.equals("null") || columnValue.equals("")){
			
			return "";
		}
		String columnNumber = (String)columnValue;
		float number = Float.valueOf(columnNumber);
		String rutnrnStr = String.format("%1$.2f", number);
		return rutnrnStr;
	}

}
