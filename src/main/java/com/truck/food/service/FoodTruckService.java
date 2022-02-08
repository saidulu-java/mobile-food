package com.truck.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truck.food.bean.MobileFood;
import com.truck.food.data.CSVDataLoad;

@Service
public class FoodTruckService {

	@Autowired
	private CSVDataLoad cSVDataLoad;

	public List<MobileFood> getAllMobileFoodDetails() {
		return cSVDataLoad.loadMobileFoodDetails();
	}

}
