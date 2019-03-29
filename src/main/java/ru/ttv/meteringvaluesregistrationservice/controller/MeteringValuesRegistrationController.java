package ru.ttv.meteringvaluesregistrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ttv.meteringvaluesregistrationservice.model.*;
import ru.ttv.meteringvaluesregistrationservice.service.AccountService;
import ru.ttv.meteringvaluesregistrationservice.service.MeteringValuesService;

import java.util.List;

/**
 * @author Teplykh Timofey  26.03.2019
 */
@Controller
public class MeteringValuesRegistrationController {

    private AccountService accountService;

    private MeteringValuesService meteringValuesService;

    @Autowired
    public MeteringValuesRegistrationController(AccountService accountService, MeteringValuesService meteringValuesService) {
        this.accountService = accountService;
        this.meteringValuesService = meteringValuesService;
    }

    @ModelAttribute("device")
    public MeteringDeviceValueDTO meteringDeviceValue() {
        return new MeteringDeviceValueDTO();
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
    public String valRegistration(@ModelAttribute("device") MeteringDeviceValueDTO value, BindingResult result, Model model){
        meteringValuesService.saveMeteringValues(value);
        model.addAttribute("result","Показания успешно сохранены");
        return "val_registration";
    }

    @GetMapping(value = "/account_search")
    public String accountSearchForm(){
        return "account_search";
    }

    @PostMapping(value = "/account_search")
    public String accountSearch(final ConsumerAccountDTO accountSearch, Model model){
        List<MeteringDeviceValueDTO> meteringDevices = accountService.getConsumerMeteringDevices(accountSearch);
        if(meteringDevices.isEmpty()){
            model.addAttribute("errors", "Лицевой счет не найден");
            return "account_search";
        }
        model.addAttribute("meteringDevices", meteringDevices);
        return "val_registration";//"redirect:/";
    }
}
