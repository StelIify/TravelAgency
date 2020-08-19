package zor.edu.demo.service.tripticket.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zor.edu.demo.datastorage.DataFake;
import zor.edu.demo.model.TravelRoute;
import zor.edu.demo.model.TripTicket;
import zor.edu.demo.repository.ClientRepository;
import zor.edu.demo.repository.TravelRouteRepository;
import zor.edu.demo.repository.TripTicketRepository;
import zor.edu.demo.service.tripticket.interfaces.ITripTicketService;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class TripTicketServiceImpl implements ITripTicketService {

    @Autowired
    TripTicketRepository tripTicketRepository;
    @Autowired
    TravelRouteRepository travelRouteRepository;
    @Autowired
    DataFake dataFake;

    List<TripTicket> tripTickets;

    @PostConstruct
    void init()
    {
        tripTickets = new LinkedList<>(
                Arrays.asList(
                        new TripTicket(travelRouteRepository.findAll().get(0), "12 of August", 5, 15),
                        new TripTicket(travelRouteRepository.findAll().get(1), "18 of August", 7, 20)));
        tripTicketRepository.saveAll(tripTickets);
    }

    @Override
    public TripTicket create(TripTicket tripTicket)
    {
        tripTicket.setCreatedAt(LocalDateTime.now());
        tripTicket.setUpdatedAt(LocalDateTime.now());
        return tripTicketRepository.save(tripTicket);
    }

    @Override
    public TripTicket get(String id)
    {
        return tripTicketRepository.findById(id).orElse(null);
    }

    @Override
    public TripTicket update(TripTicket tripTicket)
    {
        return tripTicketRepository.save(tripTicket);
    }

    @Override
    public TripTicket delete(String id)
    {
        TripTicket tripTicket = this.get(id);
        tripTicketRepository.deleteById(tripTicket.getId());
        return tripTicket;
    }

    @Override
    public List<TripTicket> getAll()
    {
        return tripTicketRepository.findAll();
    }

    public void reloadDataBase()
    {
        dataFake.init();
    }
}
