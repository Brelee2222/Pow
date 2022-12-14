import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger base = new BigInteger("47221543635");
        int expo = 1000000;
        BigInteger exponent = new BigInteger(Integer.toString(expo));
        System.out.println("as my time:");
        long timeMillis = System.currentTimeMillis();
        pow(base, exponent);
        System.out.println(System.currentTimeMillis() - timeMillis);
        System.out.println("as their time:");
        timeMillis = System.currentTimeMillis();
        base.pow(expo);
        System.out.println(System.currentTimeMillis() - timeMillis);

        System.out.println(pow(base, exponent).equals(base.pow(expo)));
    }

    public static BigInteger pow(BigInteger base, BigInteger exponent) {
        BigInteger result = BigInteger.ONE;

        for(int bitIndex = exponent.bitLength()-1; bitIndex != -1; bitIndex--) {
            if(exponent.testBit(bitIndex))
                result = result.multiply(base.multiply(result));
            else
                result = result.multiply(result);
        }

        return result;
    }
}
