import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomeHub implements SensorObserver{
    private static HomeHub instance;
    private List<ManageableDevice> devices;

    private HomeHub(){
        devices = new ArrayList<>();
    }

    @Override
    public void onSensorTriggered(String sensorId, String eventDetails) {
        System.out.println("ALARM: Wykryto ruch z czujnika " + sensorId + " (" + eventDetails + ")");
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }

    public void runDiagnostics() {
        DiagnosticsVisitor visitor = new DiagnosticsVisitor();
        for (ManageableDevice device : devices) {
            device.accept(visitor);
        }
        System.out.println(visitor.getReport());
    }

    public List<ManageableDevice> getDevices() {
        return devices;
    }

    public void registerDevice(ManageableDevice device) throws DuplicateDeviceException {
        if (device instanceof SmartDevice newDevice) {
            boolean duplicate = devices.stream()
                    .filter(d -> d instanceof SmartDevice)
                    .map(d -> (SmartDevice) d)
                    .anyMatch(existing -> existing.getId().equals(newDevice.getId())
                            || existing.getMacAddress().equals(newDevice.getMacAddress()));
            if (duplicate) {
                throw new DuplicateDeviceException("device with this id or macAddres exist" + getDevices());
            }
        }
        devices.add(device);
    }

    public List<SmartDevice> getDevicesByRoom(String room) {
        List<SmartDevice> roomList = devices.stream()
                .filter(d -> d instanceof SmartDevice)
                .map(d -> (SmartDevice) d)
                .filter(d -> d.getRoom().equals(room))
                .collect(Collectors.toList());
        Collections.sort(roomList);
        return roomList;
    }
/*
    public List<ManageableDevice> getDevicesByRoom(String room){
        //jak bedzie wywalac blad zalezny od wersji javy to .collect(Collectors.toList())
        List<SmartDevice> roomList = devices.stream()
                .filter(devicesToFind -> devicesToFind
                        .getRoom().equals(room)).toList();
        Collections.sort(roomList);
        return roomList;
    }
 */

}