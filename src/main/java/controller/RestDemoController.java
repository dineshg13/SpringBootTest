package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dinesh on 7/19/2015.
 */
@RestController
public class RestDemoController {

    @RequestMapping(value = "/", produces = "application/json")
    public String  helloUser() {
        return "helloUser";
    }
}
