package zor.edu.demo.controller.web;

import com.sun.deploy.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zor.edu.demo.form.TravelRouteForm;
import zor.edu.demo.model.Client;
import zor.edu.demo.model.TravelRoute;
import zor.edu.demo.service.client.impls.ClientServiceImpl;
import zor.edu.demo.service.travelroute.impls.TravelRouteServiceImpl;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/web/travelRoute")
public class TravelRouteWebController
{
    @Autowired
    ClientServiceImpl clientService;
    @Autowired
    TravelRouteServiceImpl travelRouteService;

    Map<String, String> movs;

    @PostConstruct
    void init()
    {
        movs = new HashMap<>();
    }
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getAll(Model model){
        model.addAttribute("list",travelRouteService.getAll());
        return "travelRouteList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTravelRoute(Model model)
    {
        TravelRouteForm travelRouteForm = new TravelRouteForm();
        for (Client client:clientService.getAll())
        {
            movs.put(client.getId(), client.getName());
        }
        model.addAttribute("movs",movs);
        model.addAttribute("travelRouteForm", travelRouteForm);
        return "addTravelRoute";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTravelRoute(Model model, @ModelAttribute("travelRouteForm") TravelRouteForm travelRouteForm)
    {
        TravelRoute travelRoute = new TravelRoute();//создаем новую группу для добавление в БД
        travelRoute.setClient(travelRouteForm.getClient());//устанавливаем ей значение имени из формы
        travelRoute.setCountry(travelRouteForm.getCountry());//устанавливаем ей значение описания из формы
        travelRoute.setClimate(travelRouteForm.getClimate());//устанавливаем  нашей группе значение новой кафедры
        travelRoute.setDuration(travelRouteForm.getDuration());
        travelRoute.setHotel(travelRouteForm.getHotel());
        travelRoute.setPrice(travelRouteForm.getPrice());

        travelRouteService.create(travelRoute);
        model.addAttribute("travelRoute", travelRouteService.getAll());
        return "redirect:/web/travelRoute/get/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String deleteTravelRoute(@PathVariable("id") String id, Model model) {
        travelRouteService.delete(id);
        model.addAttribute("list", travelRouteService.getAll());
        return "redirect:/web/travelRoute/get/list";
    }
    @RequestMapping(value = "/reloadDB", method = RequestMethod.GET)
    String reloadDataBase() {
        travelRouteService.reloadDataBase();
        return "redirect:/web/travelRoute/get/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateTravelRoute(@PathVariable("id") String id, Model model){
        TravelRoute travelRoute = travelRouteService.get(id);
        TravelRouteForm travelRouteForm = new TravelRouteForm(
                travelRoute.getId(),
                travelRoute.getClient(),
                travelRoute.getCountry(),
                travelRoute.getClimate(),
                travelRoute.getDuration(),
                travelRoute.getHotel(),
                travelRoute.getPrice()
        );
        for (Client client:clientService.getAll()){
            movs.put(client.getId(),client.getName());
        }
        model.addAttribute("movs",movs);
        model.addAttribute("travelRouteForm", travelRouteForm);
        return "updateTravelRoute";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateTravelRoute(Model model, @PathVariable("id") String id, @ModelAttribute("clientForm") TravelRouteForm travelRouteForm){
        TravelRoute travelRoute = new TravelRoute();
        travelRoute.setId(id);
        travelRoute.setClient(travelRouteForm.getClient());
        travelRoute.setCountry(travelRouteForm.getCountry());
        travelRoute.setClimate(travelRouteForm.getClimate());
        travelRoute.setDuration(travelRouteForm.getDuration());
        travelRoute.setHotel(travelRouteForm.getHotel());
        travelRoute.setPrice(travelRouteForm.getPrice());
        travelRouteService.update(travelRoute);
        model.addAttribute("travelRoute",travelRouteService.getAll());
        return "redirect:/web/travelRoute/get/list";
    }

}
