package zor.edu.demo.datastorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zor.edu.demo.model.Client;
import zor.edu.demo.model.TravelRoute;
import zor.edu.demo.model.TripTicket;
import zor.edu.demo.repository.ClientRepository;
import zor.edu.demo.repository.TravelRouteRepository;
import zor.edu.demo.repository.TripTicketRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DataFake
{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TravelRouteRepository travelRouteRepository;
    @Autowired
    TripTicketRepository tripTicketRepository;

    List<Client> clients = new LinkedList<>(Arrays.asList(
        new Client("Oleksandr", "Heroiv Krut", "0674186620", "ahoj"),
          new Client("Lexa", "Des tam ", "096137442", "none likes him very much"),
            new Client("Vlad", "Cheluskinsiv 32", "095312444", "ahoj")
    ));

    List<TravelRoute> travelRoutes = new LinkedList<>(Arrays.asList(
            new TravelRoute(clients.get(0), "Ukraine", "Humid", "5 days", "Kiev Hotel", 440),
            new TravelRoute(clients.get(1), "Austria", "Temperate", "3 days", "Austria Hotel", 600),
            new TravelRoute(clients.get(2), "Slovakia", "Temperate", "10 days", "Tatra Hotel", 500)
    ));

    List<TripTicket> tripTickets = new LinkedList<>(Arrays.asList(
            new TripTicket(travelRoutes.get(0), "19 of August", 5, 10),
            new TripTicket(travelRoutes.get(1), "25 of August", 10, 14),
            new TripTicket(travelRoutes.get(2), "2 of August", 17, 15)
    ));

    //@PostConstruct
    public void init()
    {
        clientRepository.deleteAll();
        clientRepository.saveAll(clients);
        travelRouteRepository.deleteAll();
        travelRouteRepository.saveAll(travelRoutes);
        tripTicketRepository.deleteAll();
        tripTicketRepository.saveAll(tripTickets);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<TravelRoute> getTravelRoutes() {
        return travelRoutes;
    }

    public void setTravelRoutes(List<TravelRoute> travelRoutes) {
        this.travelRoutes = travelRoutes;
    }

    public List<TripTicket> getTripTickets() {
        return tripTickets;
    }

    public void setTripTickets(List<TripTicket> tripTickets) {
        this.tripTickets = tripTickets;
    }
}
