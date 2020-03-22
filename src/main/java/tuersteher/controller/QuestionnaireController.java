package tuersteher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
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
@SessionAttributes("form")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @ModelAttribute("form")
    public QuestionnaireForm form() {
        return new QuestionnaireForm();
    }

    @GetMapping("/questionnaire1")
    String questionnaire1Get(Model model, @ModelAttribute("form") QuestionnaireForm form) {
        model.addAttribute("form", form);
        return "questionnaire1";
    }

    @PostMapping("/questionnaire1")
    RedirectView questionnaire1Post(@Valid @ModelAttribute("form") QuestionnaireForm form, Errors result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            System.out.println(result);
            return new RedirectView("/questionnaire1");
        }
        questionnaireService.processQuestionnaire1(form);
        int numberOfPassengers = form.getTrip().getNumberOfPassengers();
        List<Passenger> visaPassengers = questionnaireService.visaPassengers(form.getTrip().getPassengers());
        if (numberOfPassengers > 1) {
            for (int i = 1; i < numberOfPassengers; i++) {
                form.addPassenger(new Passenger());
            }
            attributes.addFlashAttribute("form", form);
            return new RedirectView("/questionnaire2");
        } else if (!visaPassengers.isEmpty()) {
            form.setVisaPassengers(visaPassengers);
            attributes.addFlashAttribute("form", form);
            return new RedirectView("/questionnaire3");
        }
        //TODO redirect to result
        return new RedirectView("/");
    }

    @GetMapping("/questionnaire2")
    String questionnaire2Get(Model model, @ModelAttribute("form") QuestionnaireForm form){
        model.addAttribute("form",form);
        return "questionnaire2";
    }

    @PostMapping("/questionnaire2")
    RedirectView questionnaire2Post(@Valid @ModelAttribute("form") QuestionnaireForm form, Errors result,  RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return new RedirectView("/questionnaire2");
        }
        questionnaireService.processQuestionnaire2(form);
        List<Passenger> visaPassengers = questionnaireService.visaPassengers(form.getTrip().getPassengers());
        if (!visaPassengers.isEmpty()) {
            form.setVisaPassengers(visaPassengers);
            attributes.addFlashAttribute("form", form);
            return new RedirectView("/questionnaire3");
        }
        //TODO redirect to result
        return new RedirectView("/");
    }

    @GetMapping("/questionnaire3")
    String questionnaire3Get(Model model, @ModelAttribute("form") QuestionnaireForm form){
        model.addAttribute("form",form);
        return "questionnaire3";
    }

    @PostMapping("/questionnaire3")
    String questionnaire3Post(@Valid @ModelAttribute("form") QuestionnaireForm form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "questionnaire3";
        }
        questionnaireService.processQuestionnaire3(form);
        //TODO redirect to result
        return "redirect:/";
    }

}
