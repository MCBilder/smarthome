public class Main {
    public static void main(String[] args) {
        HomeHub homeHub = HomeHub.getInstance();
        SmartHomeFacade facade = new SmartHomeFacade(homeHub);

        try {
            SmartDevice smartDevice = new SmartDevice.Builder("1", "PC").withMacAddress("11:22:33:44:55:66").build();
            SmartDevice tv = new SmartDevice.Builder("tv-1", "TV")
                    .withRoom("Living Room")
                    .withMacAddress("11:22:33:44:55:66")
                    .withFirmwareVersion(1.5)
                    .build();
            homeHub.registerDevice(tv);
            MotionSensor sensor = new MotionSensor("MS-1");
            sensor.attach(homeHub);
            sensor.detectMotion();
        }catch (InvalidMacAddressException e){
            System.out.println(e.getMessage());
        }
        /*
        SmartDevice device = new SmartDevice.Builder("1", "TV").build();
        device.turnOn();
        device.getStatus();
        device.turnOff();
        */
        LegacyThermostat legacyThermostat = new LegacyThermostat();
        ThermostatAdapter adapter = new ThermostatAdapter(legacyThermostat);
        homeHub.registerDevice(adapter);

        adapter.setStrategy(new EcoStrategy());
        adapter.applyStrategy(true);
        adapter.applyStrategy(false);

        adapter.setStrategy(new ComfortStrategy());
        adapter.applyStrategy(true);
        adapter.applyStrategy(false);

        SmartDevice bulb = DeviceFactory.createLivingRoomBulb("123", "lightBulb");
        ManageableDevice thatOneBulb = new EnergyMonitoringDecorator(bulb);
        homeHub.registerDevice(thatOneBulb);
        thatOneBulb.turnOn();

        System.out.println("\n");
        facade.goodNightRoutine();
        System.out.println("\n");
        facade.movieMode();
    }
}