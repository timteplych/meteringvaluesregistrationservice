package ru.ttv.meteringvaluesregistrationservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ttv.meteringvaluesregistrationservice.model.ConsumerAccountDTO;
import ru.ttv.meteringvaluesregistrationservice.model.MeteringDeviceValue;

import javax.validation.Valid;

/**
 * @author Teplykh Timofey  26.03.2019
 */
@Controller
public class MeteringValuesRegistrationController {

    @ModelAttribute("deviceValue")
    public MeteringDeviceValue meteringDeviceValue() {
        return new MeteringDeviceValue();
    }

    @ModelAttribute("accountSearch")
    public ConsumerAccountDTO consumerAccountDTO(){
        return new ConsumerAccountDTO();
    }

    @GetMapping(value = "/val_registration")
    public String valRegistrationForm(){
        return "val_registration";
    }

    @PostMapping(value = "/val_registration")
    public String valRegistration(@ModelAttribute("deviceValue") MeteringDeviceValue value, BindingResult result, Model model){
        return "redirect:/val_registration?success";
    }

    @GetMapping(value = "/account_search")
    public String accountSearchForm(){
        return "account_search";
    }

    @PostMapping(value = "/account_search")
    public String accountSearch(final ConsumerAccountDTO accountSearch, Model model){

        model.addAttribute("")
        return "account_search";//"redirect:/";
    }
}
