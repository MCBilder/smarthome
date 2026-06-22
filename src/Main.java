public class Main {
    public static void main(String[] args) {
        try {
            SmartDevice smartDevice = new SmartDevice.Builder("1", "PC").withMacAddress("2131").build();
        }catch (InvalidMacAddressException e){
            System.out.println(e.getMessage());
        }
        SmartDevice device = new SmartDevice.Builder("1", "tv").build();
        device.turnOn();
        device.getStatus();
        device.turnOff();

        LegacyThermostat legacyThermostat = new LegacyThermostat();
        ManageableDevice adapter = new ThermostatAdapter(legacyThermostat);

        HomeHub.getInstance().registerDevice(adapter);
    }
}