package com.codebamz.startcms.StartCMS.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//Component
public class InitConfiguration {

    //va  aobtener los datos que vengan del spring, del aplicationproperties

    //private Environment env;

    //@PostConstruct
    //public void postConstruct(){
      //  env = new StandardEnvironment();
    //}

    public List<String> getTypes() throws IOException{
        File file = new File("C:/home/application.json");
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> object = objectMapper.readValue(file, HashMap.class);
        List<HashMap> typesObjects = (List<HashMap>) object.get("post_types");

        return typesObjects.stream()
                .map(hashMap -> (String) hashMap.get("type"))
                .collect(Collectors.toList());
    }
}
