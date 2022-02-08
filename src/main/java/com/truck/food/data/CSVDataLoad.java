package com.truck.food.data;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.truck.food.bean.MobileFood;

@Component
public class CSVDataLoad {

	public List<MobileFood> loadMobileFoodDetails() {
		Map<String, String> mapping = mapCsvToJava();
		HeaderColumnNameTranslateMappingStrategy<MobileFood> strategy = new HeaderColumnNameTranslateMappingStrategy<MobileFood>();
		strategy.setType(MobileFood.class);
		strategy.setColumnMapping(mapping);
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("Mobile_Food_Facility_Permit.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new CsvToBean().parse(strategy, csvReader);
	}

	private static Map<String, String> mapCsvToJava() {
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("locationid", "locationid");
		mapping.put("applicant", "Applicant");
		mapping.put("facilityType", "FacilityType");
		mapping.put("cnn", "cnn");
		mapping.put("locationDescription", "LocationDescription");
		mapping.put("address", "Address");
		mapping.put("blocklot", "blocklot");
		mapping.put("block", "block");
		mapping.put("lot", "lot");
		mapping.put("permit", "permit");
		mapping.put("status", "Status");
		mapping.put("foodItems", "FoodItems");
		mapping.put("X", "X");
		mapping.put("Y", "Y");
		mapping.put("latitude", "Latitude");
		mapping.put("longitude", "Longitude");
		mapping.put("schedule", "Schedule");
		mapping.put("daysHours", "dayshours");
		mapping.put("NOISent", "NOISent");
		mapping.put("approved", "Approved");
		mapping.put("received", "Received");
		mapping.put("priorPermit", "PriorPermit");
		mapping.put("expirationDate", "ExpirationDate");
		mapping.put("location", "Location");
		mapping.put("firePreventionDistricts", "Fire Prevention Districts");
		mapping.put("policeDistricts", "Police Districts");
		mapping.put("supervisorDistricts", "Supervisor Districts");
		mapping.put("zipCodes", "Zip Codes");
		mapping.put("neighborhoodsOld", "Neighborhoods (old)");
		return mapping;
	}
}
