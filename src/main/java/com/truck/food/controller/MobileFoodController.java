package com.truck.food.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.truck.food.bean.MobileFood;
import com.truck.food.service.FoodTruckService;

@RestController
@RequestMapping("/mobile-truck")
public class MobileFoodController {

	@Autowired
	private FoodTruckService foodTruckService;

	@GetMapping("/dashboard")
	public List<MobileFood> getAllFoodTruckDetails() {

		return foodTruckService.getAllMobileFoodDetails();
	}

	@GetMapping("/loc/{locationid}")
	public List<MobileFood> getFoodTruckDetailsByCity(@PathVariable String locationid) {

		System.out.println(locationid);
		List<MobileFood> mobileFoodList = foodTruckService.getAllMobileFoodDetails();

		List<MobileFood> locMobileFoodList = new ArrayList<MobileFood>();
		for (MobileFood mobileFood : mobileFoodList) {
			if (mobileFood.getLocationid().equalsIgnoreCase(locationid)) {
				locMobileFoodList.add(mobileFood);
			}
		}
		return locMobileFoodList;
	}

}
