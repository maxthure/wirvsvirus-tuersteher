package tuersteher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tuersteher.model.ControlForm;
import tuersteher.model.TripStatus;
import tuersteher.service.TripControlService;

import javax.validation.Valid;

/**
 * @author Robert Rabe on 21.03.20.
 */
@Controller
@SessionAttributes("form")
public class TripControlController {

    private final TripControlService tripControlService;

    public TripControlController(TripControlService tripControlService) {
        this.tripControlService = tripControlService;
    }

    @ModelAttribute("form")
    public ControlForm controlForm() {
        return new ControlForm();
    }

    @GetMapping("/control")
    public String getTripControlForm(Model model, ControlForm form) {
        model.addAttribute("form", form);
        return "control";
    }

    @PostMapping("/control")
    public String check(@Valid @ModelAttribute("form") ControlForm form, Errors result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            form.setTrip(null);
            return getTripControlForm(model, form);
        }

        ControlForm populated = tripControlService.populateForm(form);
        model.addAttribute("form", populated);
        attributes.addFlashAttribute(form);
        return "control";
    }

    @PostMapping("/control/allow/{id}")
    public String allowPassenger(@Valid @ModelAttribute("form") ControlForm form, @PathVariable Long id, Model model, RedirectAttributes attributes) {
        form = tripControlService.updateFormPassengerStatus(form, id, TripStatus.ACCEPTED);
        model.addAttribute("form", form);
        attributes.addFlashAttribute(form);
        return "control";
    }

    @PostMapping("/control/deny/{id}")
    public String denyPassenger(@Valid @ModelAttribute("form") ControlForm form, @PathVariable Long id, Model model, RedirectAttributes attributes) {
        form = tripControlService.updateFormPassengerStatus(form, id, TripStatus.DENIED);
        model.addAttribute("form", form);
        attributes.addFlashAttribute(form);
        return "control";
    }

    @PostMapping("/control/allow")
    public String allowEntryForAll(@Valid @ModelAttribute("form") ControlForm form, Model model, RedirectAttributes attributes) {
        form = tripControlService.updateFormPassengerStatusForAll(form, TripStatus.ACCEPTED);
        model.addAttribute("form", form);
        attributes.addFlashAttribute(form);
        return "control";
    }

    @PostMapping("/control/deny")
    public String denyEntryForAll(@Valid @ModelAttribute("form") ControlForm form, Model model, RedirectAttributes attributes) {
        form = tripControlService.updateFormPassengerStatusForAll(form, TripStatus.DENIED);
        model.addAttribute("form", form);
        attributes.addFlashAttribute(form);
        return "control";
    }
}
