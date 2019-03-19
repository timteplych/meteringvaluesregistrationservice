package ru.ttv.meteringvaluesregistrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ttv.meteringvaluesregistrationservice.model.User;
import ru.ttv.meteringvaluesregistrationservice.model.UserRegistrationDto;
import ru.ttv.meteringvaluesregistrationservice.service.UserService;

import javax.validation.Valid;

/**
 * Controller for {@link ru.ttv.meteringvaluesregistrationservice.model.User}'s page
 * @author Teplykh Timofey  10.03.2019
 */

@RefreshScope
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${city.property}")
    private String prop;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @GetMapping(value = "/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result, Model model){
        User existing = userService.findByUsername(userDto.getUsername());
        if (existing != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }
        if(result.hasErrors()){
            return "registration";
        }

        userService.save(userDto);
        //securityService.autoLogin(userForm.getUsername(),userForm.getConfirmPassword());
        return "redirect:/registration?success";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout){
        if(error!=null){
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if(logout!=null){
            model.addAttribute("message","Logged out successfully.");
        }

        return "login";
    }

    @GetMapping(value = "/config")
    public String showConfig(){
        System.out.println(prop);
        return "login";
    }

    @GetMapping(value = {"/","/index"})
    public String welcome(Model model){
        return "index";
    }

    @GetMapping(value = "/admin")
    public String admin(Model model){
        return "admin";
    }
}
