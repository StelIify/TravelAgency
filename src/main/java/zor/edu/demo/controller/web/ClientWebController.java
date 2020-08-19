package zor.edu.demo.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zor.edu.demo.form.ClientForm;
import zor.edu.demo.model.Client;
import zor.edu.demo.repository.ClientRepository;
import zor.edu.demo.service.client.impls.ClientServiceImpl;

@Controller
@RequestMapping("/web/client")
public class ClientWebController
{
    @Autowired
    ClientServiceImpl clientService;

    @RequestMapping("/get/list")
    String showAll(Model model)
    {
        model.addAttribute("list", clientService.getAll());
        return "clientlist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String deleteClient(@PathVariable("id") String id, Model model)
    {

        clientService.delete(id);
        model.addAttribute("list",clientService.getAll());
        return "redirect:/web/client/get/list";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    String getClientInfo(@PathVariable("id") String id, Model model){
        Client cafedra = clientService.get(id);
        model.addAttribute("list",clientService.getAll());
        return cafedra.toString();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createClient(Model model){
        ClientForm clientForm= new ClientForm();
        model.addAttribute("clientForm", clientForm);
        return "addClient";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createClient(Model model, @ModelAttribute("clientForm") ClientForm clientForm){
        Client client = new Client();
        client.setName(clientForm.getName());
        client.setAddress(clientForm.getAddress());
        client.setPhoneNumber(clientForm.getPhoneNumber());
        client.setDescription(clientForm.getDescription());
        clientService.create(client);

        model.addAttribute("client", clientService.getAll());
        return "redirect:/web/client/get/list";
    }

    @RequestMapping(value = "/reloadDB", method = RequestMethod.GET)
    String reloadDataBase()
    {
       clientService.reloadDataBase();
        return "redirect:/web/client/get/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateClient(@PathVariable("id") String id, Model model)
    {
        Client client = clientService.get(id);
        ClientForm clientForm = new ClientForm(
                client.getId(),
                client.getName(),
                client.getAddress(),
                client.getPhoneNumber(),
                client.getDescription()
        );
        model.addAttribute("clientForm", clientForm);
        return "updateClient";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateClient(Model model, @PathVariable("id") String id,
                                @ModelAttribute ("clientForm") ClientForm clientForm)
    {
        Client client = new Client();
        client.setId(id);
        client.setName(clientForm.getName());
        client.setAddress(clientForm.getAddress());
        client.setPhoneNumber(clientForm.getPhoneNumber());
        client.setDescription(clientForm.getDescription());
        clientService.update(client);

        model.addAttribute("client", clientService.getAll());
        return "redirect:/web/client/get/list";
    }
}
