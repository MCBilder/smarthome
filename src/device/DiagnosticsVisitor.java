package device;

import thermostat.LegacyThermostat;

public class DiagnosticsVisitor implements DeviceVisitor {
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void visit(SmartDevice device) {
        buffer.append("device.SmartDevice: ")
                .append(device.getName())
                .append(", pomieszczenie: ").append(device.getRoom())
                .append(", firmware: ").append(device.getFirmwareVersion())
                .append("\n");
    }

    @Override
    public void visit(LegacyThermostat thermostat) {
        buffer.append("thermostat.LegacyThermostat, aktualna temperatura: ")
                .append(thermostat.getCurrentTemperature())
                .append("\n");
    }

    public String getReport() {
        return buffer.toString();
    }
}