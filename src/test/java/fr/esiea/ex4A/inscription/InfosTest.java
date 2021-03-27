package fr.esiea.ex4A.inscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InfosTest {

    @ParameterizedTest
    @ValueSource(strings = {"{\"userEmail\":\"giovanni@gio\",\"userName\":\"giovanni\",\"userTweeter\":\"gvnn\",\"userCountry\":\"FR\",\"userSex\":\"H\",\"userSexPref\":\"F\"}"
    })
    void test_infos(String json) throws Exception {
        Infos user = new ObjectMapper().readValue(json, Infos.class);
        System.out.println(user.toString());
        assertTrue(json.contains(user.pays));
        assertTrue(json.contains(user.email));
        assertTrue(json.contains(user.name));
        assertTrue(json.contains(user.twitter));
        assertTrue(json.contains(user.sexe));
        assertTrue(json.contains(user.sexPref));
        assertThat(user.toString()).isEqualTo("Infos{email='"+user.email
            +"', name='"+user.name
            +"', twitter='"+user.twitter
            +"', pays='"+user.pays
            +"', sexe='"+user.sexe
            +"', sexPref='"+user.sexPref+"'}");
    }

}
