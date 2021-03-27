package fr.esiea.ex4A.inscription;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MeetMockControllerTest {
    public final MockMvc mockMvc;

    @MockBean
    private CreateMatches matches;

    MeetMockControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void match_user_test() throws Exception {

        HashMap<String,Infos> userMap = new HashMap<>();
        Infos leoUser = new Infos("leo@leo","leo","leo","FR","M","F");
        Infos isabelleUser = new Infos("isabelle@isabelle","isabelle","isabelle","FR","F","M");
        userMap.put(leoUser.name,leoUser);
        userMap.put(isabelleUser.name,isabelleUser);

        HashMap<String,AgifyData> agifyMap = new HashMap<>();
        AgifyData leoInfo = new AgifyData("leo",26,303,"FR");
        AgifyData isabelleInfo = new AgifyData("isabelle",25,27695,"FR");
        agifyMap.put(leoInfo.name,leoInfo);
        agifyMap.put(isabelleInfo.name,isabelleInfo);

        List<Infos> listMatch = matches.getMatches(userMap,agifyMap,leoUser.name);

        when(matches.getMatches(userMap,agifyMap,leoUser.name)).thenReturn(listMatch);
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=leo&user_country"))
            .andExpect(status().isOk());
        verify(matches).getMatches(userMap,agifyMap,leoUser.name);
    }

}
