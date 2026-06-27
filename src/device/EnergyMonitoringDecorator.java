package device;

import java.time.LocalTime;

public class EnergyMonitoringDecorator extends DeviceDecorator {

    public EnergyMonitoringDecorator(ManageableDevice manageableDevice) {
        super(manageableDevice);
    }

    @Override
    public void turnOn(){
        super.turnOn();
        LocalTime time = LocalTime.now();
        System.out.println(time);
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

    @Override
    public void getStatus() {
        super.getStatus();
    }
}
