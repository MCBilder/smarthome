public class Main {
    public static void main(String[] args) {
        try {
            SmartDevice smartDevice = new SmartDevice.Builder("1", "PC").withMacAddress("2131").build();
        }catch (InvalidMacAddressException e){
            System.out.println(e.getMessage());
        }
    }
}