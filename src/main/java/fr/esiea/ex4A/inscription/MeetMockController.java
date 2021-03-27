package fr.esiea.ex4A.inscription;


import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MeetMockController {

    public final HashMap <String,Infos> infosMap = new HashMap<>();
    public final HashMap <String,AgifyData> agifyMap = new HashMap<>();
    public final AgifyClient agifyClient;
    public final CreateMatches createMatches;

    public MeetMockController(AgifyClient agifyClient, CreateMatches createMatches) {
        this.agifyClient = agifyClient;
        this.createMatches = createMatches;
    }


    @PostMapping("/api/inscription")
    public void inscription(@RequestBody Infos infos) throws IOException {
        Response<AgifyData> response = agifyClient.defineAge(infos.name, infos.pays).execute();
        AgifyData agifyData = response.body();
        agifyMap.put(agifyData.name,agifyData);
        //System.out.println(agifyMap);
        infosMap.put(infos.name, infos);
    }

    @GetMapping("/api/matches")
    public List<Infos> matchesUser(@RequestParam(value="userName") String name){
        final List<Infos> listUser = createMatches.getMatches(infosMap, agifyMap,name);
        return listUser;
    }
}
