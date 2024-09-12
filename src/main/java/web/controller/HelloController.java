package web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.Model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/cars")

    public String cars(HttpServletRequest request, ModelMap model) {

        List<String> listCars = new ArrayList<>();
        listCars.add(String.valueOf(new Car("red","V16","MB")));
        listCars.add(String.valueOf(new Car("green","V16","W")));
        listCars.add(String.valueOf(new Car("black","V32","Porsche")));
        listCars.add(String.valueOf(new Car("white","V16","BMW")));
        listCars.add(String.valueOf(new Car("purple","V16","AUDI")));


        if (request.getParameter("quantity") != null) {
            Integer cars = Integer.valueOf(request.getParameter("quantity"));
            List<String> listCars1 = new ArrayList<>();
            if (cars <= 0 || cars > 5) {
                cars = 5;
            }
            for (int i = 0; i < cars; i++) {
                listCars1.add(listCars.get(i));
            }

            model.addAttribute("mess", listCars1);


        } else {
            model.addAttribute("mess", listCars);
            return "cars";
        }


        return "cars";
    }
}