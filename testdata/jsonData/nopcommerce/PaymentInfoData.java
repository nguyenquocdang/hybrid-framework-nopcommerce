package jsonData.nopcommerce;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class PaymentInfoData {
	public static PaymentInfoData getUserInfo() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.RESOURCE_PATH + "userData.json"), PaymentInfoData.class);			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	@JsonProperty("visa")
	private String Visa;
	
	@JsonProperty("date")
	private String Date;
	
	@JsonProperty("cvc")
	private String CVC;


	
	
}
