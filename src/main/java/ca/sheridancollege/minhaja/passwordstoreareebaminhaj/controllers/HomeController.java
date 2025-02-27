package ca.sheridancollege.minhaja.passwordstoreareebaminhaj.controllers;

import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.beans.PasswordRecord;
import ca.sheridancollege.minhaja.passwordstoreareebaminhaj.database.DatabaseAccess;
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

    public HomeController(DatabaseAccess databaseAccess) { this.databaseAccess = databaseAccess;}


}
