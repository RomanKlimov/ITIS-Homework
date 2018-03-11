package ru.kpfu.formsvalidation.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.formsvalidation.model.User;
import ru.kpfu.formsvalidation.model.UserValidator;

/**
 * Created by Roman on 11.03.2018.
 */
@Controller
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userForm(Locale locale, Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    /*
     * Save user object
     */
    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
//    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Validated User user, BindingResult result,
                           Model model) {

        if (result.hasErrors()) {
            return "userForm";
        }
        return "success";
    }
}