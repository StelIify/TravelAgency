package zor.edu.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zor.edu.demo.model.Client;
import zor.edu.demo.service.client.impls.ClientServiceImpl;

import java.util.List;

@RequestMapping("api/client/v2")
@RestController
public class ClientRestController
{
    @Autowired
    ClientServiceImpl clientService;

    @RequestMapping("/hello")
    String getHello(){
        return "Hello from Client Controller ";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Client> getClientList()
    {
        return clientService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Client getClient(@PathVariable("id") String id)
    {
        return clientService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    Client deleteClient(@PathVariable("id") String id){
        return clientService.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Client createCafedra(@RequestBody Client client)
    {
        return clientService.create(client);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    Client updateCafedra(@PathVariable Client cafedra)
    {
        return clientService.update(cafedra);
    }
}
