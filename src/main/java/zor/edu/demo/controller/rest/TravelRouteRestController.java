package zor.edu.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zor.edu.demo.model.Client;
import zor.edu.demo.model.TravelRoute;
import zor.edu.demo.service.client.impls.ClientServiceImpl;
import zor.edu.demo.service.travelroute.impls.TravelRouteServiceImpl;

import java.util.List;

@RequestMapping("api/travelRoute/v2")
@RestController
public class TravelRouteRestController
{
    @Autowired
    TravelRouteServiceImpl travelRouteService;

    @RequestMapping("/hello")
    String getHello(){
        return "Hello from travelRoute Controller ";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<TravelRoute> getTravelRouteList()
    {
        return travelRouteService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    TravelRoute getTravelRoute(@PathVariable("id") String id)
    {
        return travelRouteService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    TravelRoute deleteTravelRoute(@PathVariable("id") String id){

        return travelRouteService.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    TravelRoute createTravelRoute(@RequestBody TravelRoute travelRoute)
    {
        return travelRouteService.create(travelRoute);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    TravelRoute updateTravelRoute(@PathVariable TravelRoute travelRoute)
    {
        return travelRouteService.update(travelRoute);
    }
}
