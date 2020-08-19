package zor.edu.demo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zor.edu.demo.form.TravelRouteForm;
import zor.edu.demo.form.TripTicketForm;
import zor.edu.demo.model.Client;
import zor.edu.demo.model.TravelRoute;
import zor.edu.demo.model.TripTicket;
import zor.edu.demo.repository.TripTicketRepository;
import zor.edu.demo.service.client.impls.ClientServiceImpl;
import zor.edu.demo.service.travelroute.impls.TravelRouteServiceImpl;
import zor.edu.demo.service.tripticket.impls.TripTicketServiceImpl;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/web/tripTicket")
public class TripTicketWebController
{
    @Autowired
    TripTicketServiceImpl tripTicketService;
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
        model.addAttribute("list",tripTicketService.getAll());
        return "tripTicketList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTripTicket(Model model)
    {
        TripTicketForm tripTicketForm = new TripTicketForm();
        for (TravelRoute travelRoute:travelRouteService.getAll())
        {
            movs.put(travelRoute.getId(), travelRoute.getCountry());
        }
        model.addAttribute("movs",movs);
        model.addAttribute("tripTicketForm", tripTicketForm);
        return "addTripTicket";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTripTicket(Model model, @ModelAttribute("tripTicketForm") TripTicketForm tripTicketForm)
    {
        TripTicket tripTicket = new TripTicket();//создаем новую группу для добавление в БД
        tripTicket.setTravelRoute(tripTicketForm.getTravelRouteId());//устанавливаем ей значение имени из формы
        tripTicket.setDateOfDeparture(tripTicketForm.getDateOfDeparture());//устанавливаем ей значение описания из формы
        tripTicket.setAmount(tripTicketForm.getAmount());//устанавливаем  нашей группе значение новой кафедры
        tripTicket.setDiscount(tripTicketForm.getDiscount());
        tripTicketService.create(tripTicket);
        model.addAttribute("tripTicketForm", tripTicketService.getAll());
        return "redirect:/web/tripTicket/get/list";
    }
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String createTripTicket(Model model, @ModelAttribute("tripTicketForm") TripTicketForm tripTicketForm)
//    {
//        TripTicket tripTicket = new TripTicket();//создаем новую группу для добавление в БД
//        TravelRoute travelRoute = travelRouteService.get(tripTicketForm.getTravelRouteId());
//        tripTicket.setTravelRoute(travelRoute);
//        tripTicket.setDateOfDeparture(tripTicketForm.getDateOfDeparture());//устанавливаем ей значение описания из формы
//        tripTicket.setAmount(tripTicketForm.getAmount());//устанавливаем  нашей группе значение новой кафедры
//        tripTicket.setDiscount(tripTicketForm.getDiscount());
//
//        tripTicketService.create(tripTicket);
//        model.addAttribute("tripTicket", tripTicketService.getAll());
//        return "redirect:/web/tripTicket/get/list";
//    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String deleteTripTicket(@PathVariable("id") String id, Model model) {
        tripTicketService.delete(id);
        model.addAttribute("list", tripTicketService.getAll());
        return "redirect:/web/tripTicket/get/list";
    }
    @RequestMapping(value = "/reloadDB", method = RequestMethod.GET)
    String reloadDataBase() {
        tripTicketService.reloadDataBase();
        return "redirect:/web/tripTicket/get/list";
    }

//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//    public String updateTripTicket(@PathVariable("id") String id, Model model)
//    {
//        TripTicket tripTicket = tripTicketService.get(id);
//        TripTicketForm tripTicketForm = new TripTicketForm();
//        tripTicketForm.setTravelRouteId(id);
//        tripTicketForm.setDateOfDeparture(tripTicket.getDateOfDeparture());
//        tripTicketForm.setAmount(tripTicket.getAmount());
//        tripTicketForm.setDiscount(tripTicket.getDiscount());
//        for (TravelRoute travelRoute:travelRouteService.getAll())
//        {
//            movs.put(travelRoute.getId(), travelRoute.getCountry());
//        }
//        model.addAttribute("movs",movs);
//        model.addAttribute("tripTicketForm", tripTicketForm);
//        return "updateTripTicket";
//    }
@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
public String updateTripTicket(@PathVariable("id") String id, Model model){
    TripTicket tripTicket = tripTicketService.get(id);
    TripTicketForm tripTicketForm = new TripTicketForm(
            tripTicket.getId(),
            tripTicket.getTravelRoute(),
            tripTicket.getDateOfDeparture(),
            tripTicket.getAmount(),
            tripTicket.getDiscount()
    );
    for (TravelRoute travelRoute:travelRouteService.getAll()){
        movs.put(travelRoute.getId(),travelRoute.getCountry());
    }
    model.addAttribute("movs",movs);
    model.addAttribute("tripTicketForm", tripTicketForm);
    return "updateTripTicket";
}
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateTripTicket(Model model, @PathVariable("id") String id, @ModelAttribute("tripTicketForm") TripTicketForm tripTicketForm)
    {
        TripTicket tripTicket = new TripTicket();
        tripTicket.setTravelRoute(tripTicketForm.getTravelRouteId());
        tripTicket.setDateOfDeparture(tripTicketForm.getDateOfDeparture());
        tripTicket.setAmount(tripTicketForm.getAmount());
        tripTicket.setDiscount(tripTicketForm.getDiscount());
        tripTicketService.update(tripTicket);
        model.addAttribute("tripTicket",tripTicketService.getAll());
        return "redirect:/web/tripTicket/get/list";
}
}
