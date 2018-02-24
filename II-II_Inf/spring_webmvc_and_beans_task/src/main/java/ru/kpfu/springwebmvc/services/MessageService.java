package ru.kpfu.springwebmvc.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Roman on 21.02.2018.
 */
@Service
public  class MessageService {

    public String getHello(){
        return "hello world";
    }
}
