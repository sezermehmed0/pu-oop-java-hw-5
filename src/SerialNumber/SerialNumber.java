package SerialNumber;

import java.util.Random;

public class SerialNumber{

    /**
     * Method for generating random serial number and render it
     * @return returns random string with random symbols
     */
    public String renderSerialNumber()
    {
        StringBuilder randomString = new StringBuilder(10);

        for (int i = 0 ; i < 10; i++)
        {
            String RANDOM_SYMBOL_CONTAINER = "AswWdSad21d4dFswWxFeP32";
            int randomCharacter = (int) (Math.random() * RANDOM_SYMBOL_CONTAINER.length());

            randomString.append(RANDOM_SYMBOL_CONTAINER.charAt(randomCharacter));
        }

        return randomString.toString();
    }
}