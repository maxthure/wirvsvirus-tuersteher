package tuersteher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tuersteher.model.Questionnaire1Form;
import tuersteher.model.QuestionnaireForm;
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

    @GetMapping("/questionnaire")
    String questionnaireGet(Model model, Questionnaire1Form form) {
        model.addAttribute("form", form);
        return "questionnaire";
    }

    @PostMapping("/questionnaire")
    String questionnairePost(@Valid @ModelAttribute("form") Questionnaire1Form form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "questionnaire";
        }
        //questionnaireService.processQuestionnaire(form);

        return "redirect:/";
    }
    
}
