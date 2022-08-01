package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.CarsDao;
import web.models.Car;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.ArrayList;

@Controller
public class CarsController {
    @Autowired
    private CarsDao carsDao;

    @GetMapping(value = "/cars")
    public String index(HttpServletRequest request, Model model) {
        java.util.List<Car> carList = new ArrayList<>();
      int count;
       try {
           count = Integer.parseInt(request.getParameter("count"));
           carList = carsDao.show(count);

       } catch (NumberFormatException e) {
           carList = carsDao.index();
       }
        model.addAttribute("carlist", carList);

        return "cartable";
    }

}