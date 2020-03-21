package tuersteher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tuersteher.model.ControlForm;
import tuersteher.service.TripControlService;

import javax.validation.Valid;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Controller
public class TripControlController {

    private final TripControlService tripControlService;

    public TripControlController(TripControlService tripControlService) {
        this.tripControlService = tripControlService;
    }

    @GetMapping("/control")
    public String getTripControlForm(Model model, ControlForm form) {
        model.addAttribute("form", form);
        return "control";
    }

    @PostMapping("/control")
    public String check(@Valid @ModelAttribute("form") ControlForm form, Errors result, Model model) {
        if (result.hasErrors()) {
            form.setTrip(null);
            return getTripControlForm(model, form);
        }

        ControlForm populated = tripControlService.populateForm(form);
        model.addAttribute("form", populated);
        return "control";
    }
}
