package ca.sheridancollege.minhaja.passwordstoreareebaminhaj.controllers;

import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.beans.PasswordRecord;
import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.database.DatabaseAccess;
import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.utilities.RandomNumberGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
    public String addPassword(@ModelAttribute PasswordRecord passwordRecord, Model model) {
        long generatedId = RandomNumberGenerator.generateRandomId();
        passwordRecord.setId(generatedId);

        databaseAccess.save(passwordRecord);

        model.addAttribute("message", "Record added successfully");
        model.addAttribute("passwordRecord", new PasswordRecord());
        return "index";
    }
}
