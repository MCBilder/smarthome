import java.util.Iterator;
import java.util.List;

public class SmartHomeFacade {
    private HomeHub homeHub;

    public SmartHomeFacade(HomeHub homeHub) {
        this.homeHub = homeHub;
    }

    public void goodNightRoutine(){
        List<ManageableDevice> devices = homeHub.getDevices();
        Iterator<ManageableDevice> iterator = devices.iterator();
        while (iterator.hasNext()){
            ManageableDevice device = iterator.next();
            if (device instanceof SmartDevice smartDevice && smartDevice.getName().equals("Thermostat")) {
                System.out.println("lowering temperature");
            }else if (device instanceof ThermostatAdapter thermostat) {
                thermostat.lowerTemperature();
                System.out.println("lowering temperature");
            }

            if(device instanceof SmartDevice smartDevice && smartDevice.getName().equals("lightBulb")){
                device.turnOff();
            }
        }
        System.out.println("Eco mode enabled.");
    }

    public void movieMode(){
        List<ManageableDevice> devices = homeHub.getDevices();
        Iterator<ManageableDevice> iterator = devices.iterator();
        while (iterator.hasNext()){
            ManageableDevice device = iterator.next();
            if (device instanceof SmartDevice smartDevice && smartDevice.getName().equals("TV")) {
                System.out.println("TV ");
                System.out.println("------");
                device.turnOn();
            } else if (device instanceof SmartDevice smartDevice && smartDevice.getName().equals("lightBulb")) {
                System.out.println("lights ");
                System.out.println("------");
                device.turnOff();
            } else if (device instanceof EnergyMonitoringDecorator) {
                System.out.println("lights ");
                System.out.println("------");
                device.turnOff(); // żarówka opakowana w dekorator - wciąż światło
            }
        }
    }
}
