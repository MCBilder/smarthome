public class ThermostatAdapter implements ManageableDevice{
    private LegacyThermostat legacyThermostat;
    private HeatingStrategy heatingStrategy;


    public ThermostatAdapter(LegacyThermostat legacyThermostat){
        this.legacyThermostat = legacyThermostat;
    }

    public void setStrategy(HeatingStrategy heatingStrategy){
        this.heatingStrategy = heatingStrategy;
    }

    public double applyStrategy(boolean isSomeoneHome){
        if (heatingStrategy == null){
            throw new IllegalStateException("Blad");
        }
        double currentC = legacyThermostat.getCurrentTemperature();
        double targetC = heatingStrategy.calculateTargetTemperature(currentC, isSomeoneHome);
        System.out.println("Strategia: " + heatingStrategy.getClass().getSimpleName()
                + "\nObecnosc: " + isSomeoneHome
                + "\nDocelowa temperatura: " + targetC + "C");
        return targetC;
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

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(legacyThermostat);
    }

    public void lowerTemperature() {
        legacyThermostat.lowerTemperature();
    }
}
