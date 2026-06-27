import java.util.ArrayList;
import java.util.List;

public class MotionSensor {
    private List<SensorObserver> observers;
    private String sensorId;

    public MotionSensor(String sensorId) {
        this.sensorId = sensorId;
        this.observers = new ArrayList<>();
    }

    public void attach(SensorObserver observer){
        observers.add(observer);
    }

    public void  detach(SensorObserver observer){
        observers.remove(observer);
    }

    public void detectMotion() {
        for (SensorObserver s : observers) {
            s.onSensorTriggered(sensorId, "Ruch wykryty");
        }
    }
}
