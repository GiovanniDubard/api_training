package fr.esiea.ex4A.inscription;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgifyData {
    public final String name;
    public final int age;
    public final int count;
    public final String country;

    public AgifyData(@JsonProperty("name") String name,
                     @JsonProperty("age") int age,
                     @JsonProperty("count") int count,
                     @JsonProperty("country_id") String country_id) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.country = country_id;
    }

    @Override
    public String toString() {
        return "AgifyData{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", count=" + count +
            ", country='" + country + '\'' +
            '}';
    }
}

