package dad.javafx.geofx.subcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.geofx.model.LocationModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LocationController implements Initializable{

    @FXML
    private GridPane viewGridPane;

    @FXML
    private Label latitudeLabel;

    @FXML
    private Label locationLabel;
    
    @FXML
    private ImageView flagImageView;

    @FXML
    private Label cityStateLabel;

    @FXML
    private Label languageLabel;

    @FXML
    private Label callCodeLabel;

    @FXML
    private Label longitudLabel;

    @FXML
    private Label zipCodeLabel;

    @FXML
    private Label timeZoneLabel;

    @FXML
    private Label currencyLabel;
	
	
    private LocationModel model = new LocationModel();
    
    public LocationController() throws IOException{
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/locationView.fxml"));
    	loader.setController(this);
    	loader.load();
    }
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		latitudeLabel.textProperty().bind(model.latitudeProperty().asString());
		longitudLabel.textProperty().bind(model.longitudeProperty().asString());
		cityStateLabel.textProperty().bind(model.cityStateProperty());
		flagImageView.imageProperty().bind(model.flagObjectProperty());
		locationLabel.textProperty().bind(model.locationProperty());
		zipCodeLabel.textProperty().bind(model.zipCodeProperty());
		languageLabel.textProperty().bind(model.languageProperty());		
		timeZoneLabel.textProperty().bind(model.timeZoneProperty());
		callCodeLabel.textProperty().bind(model.callCodeProperty());
		currencyLabel.textProperty().bind(model.currencyProperty());
		model.locationObjectProperty().addListener((o,ov,nv) -> newIP());
	}
	
	private void newIP() {
		model.setLongitude(model.getLocationObject().getLongitude());
		model.setLatitude(model.getLocationObject().getLatitude());
		model.setCityState(model.getLocationObject().getCity()+"/"+model.getLocationObject().getCountryName());
		model.setZipCode(model.getLocationObject().getZip());
		model.setLanguage(model.getLocationObject().getLocation().getLanguages().get(0).getName());
		String url="imagen/64x42/"+model.getLocationObject().getCountryCode()+".png";
		model.setFlagObject(new Image(url));
		model.setCallCode("+"+model.getLocationObject().getLocation().getCallingCode());
		try {
		model.setTimeZone(model.getLocationObject().getTimeZone().getCode());
		} catch (NullPointerException e) {
			model.setTimeZone("Requiere Suscripción");
		}
		try {	
		model.setCurrency(model.getLocationObject().getCurrency().getName()+"("+model.getLocationObject().getCurrency().getCode()+")");
	} catch (NullPointerException e) {
		model.setCurrency("Requiere Suscripción");
	}
	
	}
	
	public GridPane getView() { return viewGridPane; }
	
	public LocationModel getModel() { return model; }


}
