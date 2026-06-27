package sensor;

public interface    SensorObserver {

    void onSensorTriggered(String sensorId, String eventDetails);
}
