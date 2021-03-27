package fr.esiea.ex4A.inscription;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AgifyClientIT {

    @ParameterizedTest
    @CsvSource({
        "Leo,FR",
        "Isabelle,FR",
        "Laure,FR"
    })

    void agifyClientITtest(String name, String country) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.agify.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
        AgifyClient agifyClient = retrofit.create(AgifyClient.class);

        Response<AgifyData> response = agifyClient.defineAge(name, country).execute();
        AgifyData agifyData = response.body();
        assertEquals(agifyData.name, name);
        assertEquals(agifyData.country, country);
        assertThat(agifyData.toString()).isEqualTo("AgifyData{name='" + agifyData.name
            + "', age=" + agifyData.age
            + ", count=" + agifyData.count
            + ", country='" + agifyData.country + "'}");
    }

}
