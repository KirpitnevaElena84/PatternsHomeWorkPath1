package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }

    private static final Faker faker = new Faker(new Locale("ru"));

    private static final String[] cities = {
            "Майкоп", "Барнаул", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Москва", "Новосибирск"
    };

    public static String generateCity() {
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateDate(int daysToAdd) {
        return LocalDate.now().plusDays(daysToAdd)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName() {
        return faker.name().fullName().replace("ё", "Е");
    }

    public static String generatePhone() {
        return faker.numerify("+7##########");
    }

    @Value
    public static class RegistrationInfo {
        String city;
        String name;
        String phone;
    }

    public static RegistrationInfo generateUser(String city) {
        return new RegistrationInfo(city, generateName(), generatePhone());
    }
}