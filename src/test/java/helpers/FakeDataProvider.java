package helpers;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.*;

public class FakeDataProvider {

    private static Faker faker = new Faker(new Locale("ru"));
    private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"),
            new RandomService());

    public static String fakeEmail() {
        return fakeValuesService.bothify("????##@gmail.com");
    }

    public static int randomNumber() {
        return faker.number().randomDigit();
    }

    public static String fakeName() {
        return faker.name().fullName();
    }

    public static String gender() {
        List<String> genders = new ArrayList(Arrays.asList("Male", "Female"));
        return genders.get(new Random().nextInt(genders.size()));
    }

    public static String status() {
        List<String> statuses = new ArrayList(Arrays.asList("Active", "Inactive"));
        return statuses.get(new Random().nextInt(statuses.size()));
    }


}
