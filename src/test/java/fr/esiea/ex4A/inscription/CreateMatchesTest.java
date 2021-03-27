package fr.esiea.ex4A.inscription;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CreateMatchesTest {
    public final CreateMatches matches = new CreateMatches();
    @Test
    void matches_test() throws Exception {
        HashMap<String,Infos> userMap = new HashMap<>();
        Infos joakimUser = new Infos("leo@leo","leo","leo","FR","M","F");
        Infos isabelleUser = new Infos("isabelle@isabelle","isabelle","isabelle","FR","F","M");
        userMap.put(joakimUser.name,joakimUser);
        userMap.put(isabelleUser.name,isabelleUser);

        HashMap<String,AgifyData> agifyMap = new HashMap<>();
        AgifyData joakimInfo = new AgifyData("leo",54,303,"FR");
        AgifyData isabelleInfo = new AgifyData("isabelle",51,27695,"FR");
        agifyMap.put(joakimInfo.name,joakimInfo);
        agifyMap.put(isabelleInfo.name,isabelleInfo);

        List<Infos> listMatch = matches.getMatches(userMap,agifyMap,joakimUser.name);
        assertThat(listMatch).contains(isabelleUser);
    }


}
