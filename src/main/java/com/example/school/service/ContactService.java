package com.example.school.service;
import com.example.school.controller.ContactController;
import com.example.school.controller.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {
    private int counter=0;
    public ContactService(){
        System.out.println("Contact Service Bean initialized ");
    }
//    private static Logger log= LoggerFactory.getLogger(ContactController.class);
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=true;
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
