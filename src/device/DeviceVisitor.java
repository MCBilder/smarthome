package device;

import thermostat.LegacyThermostat;

public interface DeviceVisitor {
    void visit(SmartDevice device);
    void visit(LegacyThermostat thermostat);
}