package zor.edu.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zor.edu.demo.model.TravelRoute;
import zor.edu.demo.model.TripTicket;
import zor.edu.demo.service.travelroute.impls.TravelRouteServiceImpl;
import zor.edu.demo.service.tripticket.impls.TripTicketServiceImpl;

import java.util.List;

@RequestMapping("api/tripTicket/v2")
@RestController
public class TripTicketRestController
{
    @Autowired
    TripTicketServiceImpl tripTicketService;

    @RequestMapping("/hello")
    String getHello(){
        return "Hello from travelRoute Controller ";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<TripTicket> getTripTicketList()
    {
        return tripTicketService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    TripTicket getTripTicket(@PathVariable("id") String id)
    {
        return tripTicketService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    TripTicket deleteTripTicket(@PathVariable("id") String id)
    {
        return tripTicketService.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    TripTicket createTripTicket(@RequestBody TripTicket tripTicket)
    {
        return tripTicketService.create(tripTicket);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    TripTicket updateTripTicket(@PathVariable TripTicket tripTicket)
    {
        return tripTicketService.update(tripTicket);
    }
}
