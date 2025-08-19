package com.demo.nameService.services;

import com.demo.nameService.requests.Name;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    public String concatenate(Name name){
        return name.getName()+" "+name.getSurname();
    }
}
