package com.sinosoft.util;

import java.text.ParseException;
import java.util.Date;

import org.compass.core.converter.extended.DataTimeConverter;
import org.displaytag.decorator.ColumnDecorator;
import org.displaytag.exception.DecoratorException;

public class FormatDateColumnDecorator implements ColumnDecorator {

	@Override
	public String decorate(Object columnValue) throws DecoratorException {
		if(columnValue instanceof  Date){
			Date columnDate = (Date) columnValue;
			String dateStr = DateTimeUtils.format(columnDate, "yyyy-MM-dd");
			return dateStr;
		}else if(columnValue instanceof String){
			String date = (String) columnValue;
			try {
				Date dateTime = DateTimeUtils.convertStringToDate("yyyy-MM-dd",date);
				return DateTimeUtils.DateToString(dateTime, "yyyy-MM-dd");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(columnValue instanceof  java.sql.Date){
			java.sql.Date columnDate = (java.sql.Date) columnValue;
			String dateStr = DateTimeUtils.format(columnDate, "yyyy-MM-dd");
			return dateStr;
		}
		return null;
	}

}
