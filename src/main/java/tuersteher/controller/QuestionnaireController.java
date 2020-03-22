package tuersteher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tuersteher.model.Passenger;
import tuersteher.model.PassengerTrip;
import tuersteher.model.QuestionnaireForm;
import tuersteher.service.QuestionnaireService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Thure Nebendahl on 21.03.20
 */
@Controller
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/questionnaire1")
    String questionnaire1Get(Model model, QuestionnaireForm form) {
        model.addAttribute("form", form);
        return "questionnaire1";
    }

    @PostMapping("/questionnaire1")
    String questionnaire1Post(@Valid @ModelAttribute("form") QuestionnaireForm form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "questionnaire1";
        }
        questionnaireService.processQuestionnaire1(form);
        int numberOfPassengers = form.getTrip().getNumberOfPassengers();
        List<Passenger> visaPassengers = questionnaireService.visaPassengers(form.getTrip().getPassengers());
        if (numberOfPassengers > 1){
            for (int i = 1; i < numberOfPassengers; i++) {
                form.addPassenger(new Passenger());
            }
            model.addAttribute("form", form);
            return "questionnaire2";
        }
        else if(!visaPassengers.isEmpty()){
            form.setVisaPassengers(visaPassengers);
            return "questionnaire3";
        }
        //TODO redirect to result
        return "redirect:/";
    }

    @PostMapping("/questionnaire2")
    String questionnaire2Post(@Valid @ModelAttribute("form") QuestionnaireForm form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "questionnaire2";
        }
        questionnaireService.processQuestionnaire2(form);
        List<Passenger> visaPassengers = questionnaireService.visaPassengers(form.getTrip().getPassengers());
        if(!visaPassengers.isEmpty()){
            form.setVisaPassengers(visaPassengers);
            return "questionnaire3";
        }
        //TODO redirect to result
        return "redirect:/";
    }

    @PostMapping("/questionnaire3")
    String questionnaire3Post(@Valid @ModelAttribute("form") QuestionnaireForm form, Errors result, Model model){
        if (result.hasErrors()) {
            return "questionnaire3";
        }
        questionnaireService.processQuestionnaire3(form);
        //TODO redirect to result
        return "redirect:/";
    }
    
}
