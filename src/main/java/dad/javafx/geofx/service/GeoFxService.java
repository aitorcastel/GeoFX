package dad.javafx.geofx.service;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.geofx.message.IPAPIMessage;

public class GeoFxService {
	private IPAPIMessage locationMensagge;
	public GeoFxService() {
		Unirest.setObjectMapper(new dad.javafx.geofx.client.UnirestObjectMapper());
		
	}
	public IPAPIMessage  getLocationData(String ip)  {
		String url="http://api.ipapi.com/api/"+ip+"?access_key=beec2ac63e72ba605a04d36bc441025c";
			
			try {
				locationMensagge = Unirest.get(url).asObject(IPAPIMessage.class)
						.getBody();
				
				return locationMensagge;
			} catch (UnirestException e) {
				e.printStackTrace();
			}
		return null;

	}
}
