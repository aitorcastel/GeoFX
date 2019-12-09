package dad.javafx.geofx.model;

import dad.javafx.geofx.message.IPAPIMessage;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class LocationModel {

	private DoubleProperty longitude = new SimpleDoubleProperty();
	private DoubleProperty latitude = new SimpleDoubleProperty();

	private StringProperty location = new SimpleStringProperty();
	private StringProperty cityState = new SimpleStringProperty();
	private StringProperty language = new SimpleStringProperty();
	private StringProperty currency = new SimpleStringProperty();
	private StringProperty timeZone = new SimpleStringProperty();
	private StringProperty callCode = new SimpleStringProperty();
	private StringProperty zipCode = new SimpleStringProperty();

	
	private ObjectProperty<Image> flagObject = new SimpleObjectProperty<Image>();
	private ObjectProperty<IPAPIMessage> locationObject = new SimpleObjectProperty<IPAPIMessage>();
	public final DoubleProperty longitudeProperty() {
		return this.longitude;
	}
	
	public final double getLongitude() {
		return this.longitudeProperty().get();
	}
	
	public final void setLongitude(final double longitude) {
		this.longitudeProperty().set(longitude);
	}
	
	public final DoubleProperty latitudeProperty() {
		return this.latitude;
	}
	
	public final double getLatitude() {
		return this.latitudeProperty().get();
	}
	
	public final void setLatitude(final double latitude) {
		this.latitudeProperty().set(latitude);
	}
	
	public final StringProperty locationProperty() {
		return this.location;
	}
	
	public final String getLocation() {
		return this.locationProperty().get();
	}
	
	public final void setLocation(final String location) {
		this.locationProperty().set(location);
	}
	
	public final StringProperty cityStateProperty() {
		return this.cityState;
	}
	
	public final String getCityState() {
		return this.cityStateProperty().get();
	}
	
	public final void setCityState(final String cityState) {
		this.cityStateProperty().set(cityState);
	}
	
	public final StringProperty languageProperty() {
		return this.language;
	}
	
	public final String getLanguage() {
		return this.languageProperty().get();
	}
	
	public final void setLanguage(final String language) {
		this.languageProperty().set(language);
	}
	
	public final StringProperty currencyProperty() {
		return this.currency;
	}
	
	public final String getCurrency() {
		return this.currencyProperty().get();
	}
	
	public final void setCurrency(final String currency) {
		this.currencyProperty().set(currency);
	}
	
	public final StringProperty timeZoneProperty() {
		return this.timeZone;
	}
	
	public final String getTimeZone() {
		return this.timeZoneProperty().get();
	}
	
	public final void setTimeZone(final String timeZone) {
		this.timeZoneProperty().set(timeZone);
	}
	
	public final StringProperty callCodeProperty() {
		return this.callCode;
	}
	
	public final String getCallCode() {
		return this.callCodeProperty().get();
	}
	
	public final void setCallCode(final String callCode) {
		this.callCodeProperty().set(callCode);
	}
	
	public final StringProperty zipCodeProperty() {
		return this.zipCode;
	}
	
	public final String getZipCode() {
		return this.zipCodeProperty().get();
	}
	
	public final void setZipCode(final String zipCode) {
		this.zipCodeProperty().set(zipCode);
	}
	
	public final ObjectProperty<Image> flagObjectProperty() {
		return this.flagObject;
	}
	
	public final Image getFlagObject() {
		return this.flagObjectProperty().get();
	}
	
	public final void setFlagObject(final Image flagObject) {
		this.flagObjectProperty().set(flagObject);
	}
	
	public final ObjectProperty<IPAPIMessage> locationObjectProperty() {
		return this.locationObject;
	}
	
	public final IPAPIMessage getLocationObject() {
		return this.locationObjectProperty().get();
	}
	
	public final void setLocationObject(final IPAPIMessage locationObject) {
		this.locationObjectProperty().set(locationObject);
	}
	

	
	
}
