package com.example.school.controller;
import org.springframework.ui.Model;
import com.example.school.controller.model.Contact;
import com.example.school.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Controller
@Slf4j
public class ContactController {

//    private static Logger log= LoggerFactory.getLogger(ContactController.class);
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model){
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }


// @RequestMapping(value = "/saveMsg",method = POST)
//   public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                   @RequestParam String email, @RequestParam String subject, @RequestParam String message) {
//       log.info("Name : " + name);
//       log.info("Mobile Number : " + mobileNum);
//       log.info("Email Address : " + email);
//       log.info("Subject : " + subject);
//       log.info("Message : " + message);
//       return new ModelAndView("redirect:/contact");
//   }

    @RequestMapping(value = "/saveMsg",method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {

        if(errors.hasErrors()){
            log.error("Contact form validation failed due to : " + errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        contactService.setCounter(contactService.getCounter()+1);
        log.info("Number of times the contact form is submitted : " + contactService.getCounter());
//        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
}
