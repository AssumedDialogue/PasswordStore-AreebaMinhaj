package ca.sheridancollege.minhaja.passwordstoreareebaminhaj.controllers;

import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.beans.PasswordRecord;
import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.database.DatabaseAccess;
import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.utilities.RandomNumberGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {
    private DatabaseAccess databaseAccess;

    public HomeController(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    //this shows the home page
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("passwordRecords", new PasswordRecord());
        return "index";
    }

    @PostMapping("/addPassword")
    public String addPassword(
            @RequestParam String title,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String url,
            @RequestParam String email,
            @RequestParam String notes,
            RedirectAttributes redirectAttributes) {

        long generatedId = RandomNumberGenerator.generateRandomId();

        PasswordRecord passwordRecord = new PasswordRecord();
        passwordRecord.setId(generatedId);
        passwordRecord.setTitle(title);
        passwordRecord.setUsername(username);
        passwordRecord.setPassword(password);
        passwordRecord.setUrl(url);
        passwordRecord.setEmail(email);
        passwordRecord.setNotes(notes);
        databaseAccess.save(passwordRecord);

        redirectAttributes.addFlashAttribute("successMessage", "Password record successfully added!");

        return "redirect:/";
    }

    @GetMapping("/viewPasswordRecords")
    public ModelAndView viewPasswordRecords(){
        return new ModelAndView("viewPasswordRecord", "passwordRecords", databaseAccess.findAll());

    }

    @GetMapping("/searchPassword")
    public ModelAndView searchPassword(@RequestParam("title") String searchTitle) {
        List<PasswordRecord> matchingRecords = databaseAccess.findByTitle(searchTitle);
        return new ModelAndView("searchPasswordRecord", "passwordRecords", matchingRecords);
    }
}
