public class SmartDevice implements Comparable<SmartDevice> {
    private String id;
    private String name;
    private String room;
    private String macAddress;
    private double firmwareVersion;

    @Override
    public int compareTo(SmartDevice o) {
        int result = this.name.compareTo(o.name);
        if(result == 0){
            return this.room.compareTo(o.room);
        }
        return result;
    }

    private SmartDevice(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.room = builder.room;
        this.macAddress = builder.macAddress;
        this.firmwareVersion = builder.firmwareVersion;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public double getFirmwareVersion() {
        return firmwareVersion;
    }

    public static class Builder {
        private final String id;
        private final String name;

        private String room;
        private String macAddress;
        private double firmwareVersion;

        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder withRoom(String room) {
            this.room = room;
            return this;
        }

        public Builder withMacAddress(String macAddress) throws InvalidMacAddressException{
            if (macAddress.length() != 17 || !macAddress.contains(":")) {
                throw new InvalidMacAddressException("Fail to obtain correct address");
            }
            this.macAddress = macAddress;
            return this;
        }

        public Builder withFirmwareVersion(double firmwareVersion) {
            this.firmwareVersion = firmwareVersion;
            return this;
        }

        public SmartDevice build() {
            return new SmartDevice(this);
        }

    }
}
