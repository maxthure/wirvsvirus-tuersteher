package tuersteher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tuersteher.model.Passenger;
import tuersteher.model.Questionnaire1Form;
import tuersteher.model.Questionnaire2Form;
import tuersteher.service.QuestionnaireService;

import javax.validation.Valid;

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
    String questionnaire1Get(Model model, Questionnaire1Form form) {
        model.addAttribute("form", form);
        return "questionnaire1";
    }

    @PostMapping("/questionnaire1")
    String questionnaire1Post(@Valid @ModelAttribute("form") Questionnaire1Form form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "questionnaire1";
        }
        if (form.getTrip().getNumberOfPassengers() > 1){
            return "redirect:/questionnaire2/"+form.getTrip().getNumberOfPassengers();
        }
        //questionnaireService.processQuestionnaire(form);

        return "redirect:/";
    }

    @GetMapping("/questionnaire2/{numberOfPassengers}")
    String questionnaire2Get(@PathVariable int numberOfPassengers, Model model, Questionnaire2Form form) {
        for (int i = 0; i < numberOfPassengers; i++) {
            form.addPassenger(new Passenger());
        }
        model.addAttribute("form", form);
        return "questionnaire2";
    }

    @PostMapping("/questionnaire2")
    String questionnaire2Post(@Valid @ModelAttribute("form") Questionnaire2Form form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "questionnaire2";
        }
        //questionnaireService.processQuestionnaire(form);

        return "redirect:/";
    }
    
}
