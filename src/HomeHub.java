import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomeHub{
    private static HomeHub instance;
    private List<ManageableDevice> devices;

    private HomeHub(){
        devices = new ArrayList<>();
    }

    public static HomeHub getInstance() {
        if (instance == null) {
            instance = new HomeHub();
        }
        return instance;
    }

    public void registerDevice(SmartDevice device) throws DuplicateDeviceException{
        if(devices.stream().anyMatch(inListDevice -> inListDevice.getId().equals(device.getId()))){
            throw new DuplicateDeviceException("device with this id or macAddres exist");
        }
        devices.add(device);
    }

    public List<ManageableDevice> getDevicesByRoom(String room){
        //jak bedzie wywalac blad zalezny od wersji javy to .collect(Collectors.toList())
        List<SmartDevice> roomList = devices.stream().filter(devicesToFind -> devicesToFind.getRoom().equals(room)).toList();
        Collections.sort(roomList);
        return roomList;
    }
}