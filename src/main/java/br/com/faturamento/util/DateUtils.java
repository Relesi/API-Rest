package br.com.faturamento.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {
	
	public static java.util.Date str2SqlDate (String strData){
		
		@SuppressWarnings("deprecation")
		java.util.Date utilDate = new java.util.Date(strData);    	
    	return utilDate;
    	
	}
	
	public static java.sql.Date utilDate2SqlDate (java.util.Date dateData){		
		
    	java.sql.Date sqlData = new java.sql.Date(dateData.getTime());
    	return sqlData;
    	
	}
	
	public static String retornaMesAnoAtual() {
		DateFormat df = new SimpleDateFormat("MMyyyy");
        return df.format(new Date());
	}
	
	public static String retornaDiaMesAnoHoraSequencialAtual() {
		DateFormat df = new SimpleDateFormat("ddMMyyyyhhmmss");
        return df.format(new Date());
	}
	
	public static String retornaDataUSAAtual() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
	}

	public static String converteDataPTBRToUSA(String dataPTBR) {

		if(StringUtils.isNotBlank(dataPTBR) && dataPTBR.length() >= 10) {
			return dataPTBR.substring(6, 10) + "-" + dataPTBR.substring(3, 5) + "-" + dataPTBR.substring(0, 2);
		}
		return "";
	}
	
	public static String converteDateTimePTBRToUSA(String dateTimePTBR) {

		if(StringUtils.isNotBlank(dateTimePTBR) && dateTimePTBR.length() >= 16) {
			return dateTimePTBR.substring(6, 10) + "-" 
			+ dateTimePTBR.substring(3, 5) + "-" 
			+ dateTimePTBR.substring(0, 2) + " "
			+ dateTimePTBR.substring(11, 16) + ":00:000";
		}
		return "";
	}
	
	public static String converteDateTimeUSAToPTBR(String dateTimeUSA) {

		if(StringUtils.isNotBlank(dateTimeUSA) && dateTimeUSA.length() >= 18) {
			return dateTimeUSA.substring(8, 10) + "/" 
			+ dateTimeUSA.substring(5, 7) + "/" 
			+ dateTimeUSA.substring(0, 4) + " "
			+ dateTimeUSA.substring(11, 16);
		}
		return "";
	}

}
