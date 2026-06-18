import java.util.ArrayList;
import java.util.List;

public class HomeHub {
    private static HomeHub instance;
    private List<SmartDevice> devices;

    private HomeHub(){
        devices = new ArrayList<>();
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }

    public List<SmartDevice> registerDevice(SmartDevice device) throws DuplicateDeviceException{
        if(devices.stream().anyMatch(inListDevice -> inListDevice.getId().equals(device.getId()))){
            throw new DuplicateDeviceException("device with this id or macAddres exist")
        }
        devices.add(device);
    }
}