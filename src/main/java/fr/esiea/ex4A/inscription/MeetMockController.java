package fr.esiea.ex4A.inscription;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MeetMockController {

    public final HashMap <String,Infos> infosMap = new HashMap<>();

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody Infos infos) {
        infosMap.put(infos.name, infos);
    }

    @GetMapping("/api/matches")
    public List<Infos> matchesUser(@RequestParam(value="userName") String name){
        final List<Infos> listUser = new ArrayList<>();
        for(Infos infos: infosMap.values()){
            listUser.add(infos);
        }
        return listUser;
    }
}
