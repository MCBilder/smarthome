public class ThermostatAdapter implements ManageableDevice{
    private LegacyThermostat legacyThermostat;


    public ThermostatAdapter(LegacyThermostat legacyThermostat) {
        this.legacyThermostat = legacyThermostat;
    }

    @Override
    public void turnOn() {
        legacyThermostat.enableHeating();
    }

    @Override
    public void turnOff() {
        legacyThermostat.disableHeating();
    }

    @Override
    public void getStatus() {
        legacyThermostat.fetchCurrentTemperature();
    }

    public void lowerTemperature() {
        legacyThermostat.lowerTemperature();
    }
}
