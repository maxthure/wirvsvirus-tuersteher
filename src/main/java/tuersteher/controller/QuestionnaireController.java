package tuersteher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tuersteher.model.Passenger;
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
        int numberOfPassengers = form.getTrip().getNumberOfPassengers();
        //TODO Warum returnt getPassengers PassengerTrips?
        //List<Passenger> visaPassengers = questionnaireService.visaPassengers(form.getTrip().getPassengers());
        questionnaireService.processQuestionnaire1(form);
        if (numberOfPassengers > 1){
            for (int i = 1; i < numberOfPassengers; i++) {
                form.addPassenger(new Passenger());
            }
            model.addAttribute("form", form);
            return "questionnaire2";
        }

        //TODO check if redirect to questionnaire3 is necessary else redirect to the end
        return "redirect:/";
    }

    @PostMapping("/questionnaire2")
    String questionnaire2Post(@Valid @ModelAttribute("form") QuestionnaireForm form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "questionnaire2";
        }
        questionnaireService.processQuestionnaire2(form);

        //TODO check if redirect to questionnaire3 is necessary else redirect to the end
        return "redirect:/";
    }
    
}
