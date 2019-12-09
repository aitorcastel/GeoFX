package dad.javafx.geofx.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.geofx.message.IPAPIMessage;
import dad.javafx.geofx.service.GeoFxService;
import dad.javafx.geofx.subcontroller.LocationController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


/* -------------------------------------------------------
 * Vbox básica con las tabs del programa
 * 
 * > Aqui se una imageView que contiene el logo del wifi
 * > Un textField para introducir la ip
 * > Y el checkButton para realizar la comprobacion
 * 
 * > En adicción se añaden las tabs donde irá los resultados de la api
 * ---------------------------------------------------------
 */

public class GeofxController implements Initializable{

    @FXML
    private VBox viewVbox;

    @FXML
    private ImageView wifiIconImageView;

    @FXML
    private TextField ipTextField;

    @FXML
    private Button checkButton;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab locationTab;

    @FXML
    private Tab connectionTab;

    @FXML
    private Tab securityTab;
    
    // inicializacion de los controlers de las tabs
    
    private LocationController locationController = new LocationController();
   // private ConnectionController connectionController = new ConnectionController();
   // private SecurityController securityController = new SecurityController();
	
    private StringProperty ip = new SimpleStringProperty();
    private ObjectProperty<IPAPIMessage> locationObject = new SimpleObjectProperty<IPAPIMessage>();
    
	
    public GeofxController() throws IOException {
		FXMLLoader loader  = new FXMLLoader(getClass().getResource("/fxml/geofxmainView.fxml"));
		loader.setController(this);
		loader.load();
	}
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		locationTab.setContent(locationController.getView());
	//	connectionTab.setContent(connectionController.getView());
	//	securityTab.setContent(securityController.getView());
		
		ipTextField.textProperty().bindBidirectional(ip);
		
		locationController.getModel().locationObjectProperty().bind(locationObject);
	//	connectionController.getModel().locationObjectProperty().bind(locationObject);
	//	securityController.getModel().locationObjectProperty().bind(locationObject);
		
		try(java.util.Scanner string = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
			
			ip.set(string.next());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    @FXML
    void oncheckButtonAction(ActionEvent event) throws MalformedURLException{
    	Task<IPAPIMessage> buttonLaunchTask = new Task<IPAPIMessage>() {

			@Override
			protected IPAPIMessage call() throws Exception {
		    	GeoFxService geoService =new GeoFxService(); 
		    	IPAPIMessage locationMessage=new IPAPIMessage();
		    	locationMessage=geoService.getLocationData(ip.get());
		    if(locationMessage.getLatitude()==null)
					throw new Exception();
				return  locationMessage;
			}
			
			
		};
		buttonLaunchTask.setOnSucceeded(e -> {
			locationObject.bind(buttonLaunchTask.valueProperty());
		});

		new Thread(buttonLaunchTask).start();
    }
    
    public VBox getView() { return viewVbox; }
	
	

}
