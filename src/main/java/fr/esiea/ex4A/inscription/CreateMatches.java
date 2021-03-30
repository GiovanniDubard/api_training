package fr.esiea.ex4A.inscription;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CreateMatches {
    public List<Infos> getMatches(HashMap<String,Infos> userMap, HashMap<String,AgifyData> agifyMap, String name) {
        final AgifyData userAgify = agifyMap.get(name); final Infos infos = userMap.get(name); final List<Infos> matches = new ArrayList<>();
        for(AgifyData i : agifyMap.values()){
            if(i.age<= userAgify.age+4 && i.age>= userAgify.age-4){
                Infos potentialMatch = userMap.get(i.name);
                if(potentialMatch.sexe.equals(infos.sexPref) && potentialMatch.pays.equals(infos.pays) && infos.twitter!= potentialMatch.twitter){ matches.add(userMap.get(i.name)); }
            }
        }
        return matches;
    }
}
