public abstract class DeviceDecorator implements ManageableDevice{
    protected ManageableDevice manageableDevice;

    public DeviceDecorator(ManageableDevice manageableDevice) {
        this.manageableDevice = manageableDevice;
    }

    @Override
    public void turnOn() {
        manageableDevice.turnOn();
    }

    @Override
    public void turnOff() {
        manageableDevice.turnOff();
    }

    @Override
    public void getStatus() {
        manageableDevice.getStatus();
    }
}
