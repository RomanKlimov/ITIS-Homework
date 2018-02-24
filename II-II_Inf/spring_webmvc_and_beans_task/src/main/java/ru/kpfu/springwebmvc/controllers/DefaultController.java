package ru.kpfu.springwebmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.springwebmvc.services.MessageService;

/**
 * 
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
@Controller
public class DefaultController {

  @Autowired
  private MessageService messageService;

  @RequestMapping("/")
  @ResponseBody
  public String index(){
    return messageService.getHello();
//    return "Hello world from controller.";
  }
}
