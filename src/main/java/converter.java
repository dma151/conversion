import java.util.ArrayList;

public class converter {

    public static void main(String[] args) {
        String binaryString = "101010101";
        String s = "1011001";
        System.out.println(parseBinary(binaryString));
        System.out.println(parseBinary((s)));
    }

    public static int parseBinary(String s) {
        String[] stringArray = s.split("");
        int base10 = 0;
        for (int i = 0; i < s.length(); i++) {
            base10 += Integer.parseInt(stringArray[i]) * Math.pow(2, s.length() - 1 - i);
        }
        return base10;
    }
}
