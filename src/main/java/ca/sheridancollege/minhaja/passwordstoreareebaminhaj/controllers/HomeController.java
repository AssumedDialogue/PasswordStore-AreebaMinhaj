package ca.sheridancollege.minhaja.passwordstoreareebaminhaj.controllers;

import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.beans.PasswordRecord;
import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.database.DatabaseAccess;
import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.utilities.RandomNumberGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String addPassword(@ModelAttribute PasswordRecord passwordRecord, Model model) {
        long generatedId = RandomNumberGenerator.generateRandomId();
        passwordRecord.setId(generatedId);

        databaseAccess.save(passwordRecord);

        model.addAttribute("message", "Record added successfully");
        model.addAttribute("passwordRecord", new PasswordRecord());
        return "index";
    }

    @GetMapping("/viewPasswordRecords")
    public String viewPasswordRecords(Model model) {
        List<PasswordRecord> records = (List<PasswordRecord>) databaseAccess.findAll();
        model.addAttribute("passwordRecords", records);
        return "viewPasswordRecords";
    }

    @GetMapping("/searchPassword")
    public String searchPassword(@RequestParam("title") String title, Model model) {
        List<PasswordRecord> results = databaseAccess.findByTitle(title);

        if (results.isEmpty()) {
            model.addAttribute("message", "Record Not Found!");
        } else {
            model.addAttribute("results", results);
        }
        return "searchPasswordRecord";
    }
}
