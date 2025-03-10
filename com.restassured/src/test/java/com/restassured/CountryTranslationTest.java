package com.restassured;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CountryTranslationTest {
	 @Test(dataProvider = "translations")
	    public void testCountryTranslation(String translation) {
	        RestAssured.baseURI = "https://restcountries.com/v3.1/translation/";
	        
	        Response response = RestAssured.given().get(translation);
	        
	        // Add assertions or other processing of the response
	        System.out.println(response.getBody().asString());
	    }
	    
	    @DataProvider(name = "translations")
	    public Object[][] translationData() throws IOException {
	        return ExcelData.readExcelData("src/test/resources/testdata/Testdata.xlsx", "Sheet1");
	    }
}
