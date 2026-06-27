public interface DeviceVisitor {
    void visit(SmartDevice device);
    void visit(LegacyThermostat thermostat);
}