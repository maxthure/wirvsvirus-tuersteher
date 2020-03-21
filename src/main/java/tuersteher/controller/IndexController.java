package tuersteher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Thure Nebendahl on 21.03.20
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/questionnaire")
    String register(Model model, QuestionnaireForm form) {
        model.addAttribute("form", form);
        return "questionnaire";
    }

    @PostMapping("/questionnaire")
    String registerNew(@Valid @ModelAttribute("form") QuestionnaireForm form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        return "redirect:/";
    }
}
