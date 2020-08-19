package zor.edu.demo.service.travelroute.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zor.edu.demo.datastorage.DataFake;
import zor.edu.demo.model.TravelRoute;
import zor.edu.demo.repository.ClientRepository;
import zor.edu.demo.repository.TravelRouteRepository;
import zor.edu.demo.service.travelroute.interfaces.ITravelRouteService;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class TravelRouteServiceImpl implements ITravelRouteService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TravelRouteRepository travelRouteRepository;
    @Autowired
    DataFake dataFake;

    List<TravelRoute> travelRoutes;

    @PostConstruct
    void init()
    {
        travelRoutes = new LinkedList<>(
                Arrays.asList(
                        new TravelRoute(clientRepository.findAll().get(0), "Ukraine", "Humid", "5 days", "Kiev Hotel", 440),
                        new TravelRoute(clientRepository.findAll().get(1), "Slovakia", "Temperate", "10 days", "Tatra Hotel", 500)));
                        travelRouteRepository.saveAll(travelRoutes);
    }
    @Override
    public TravelRoute create(TravelRoute travelRoute)
    {
        travelRoute.setCreatedAt(LocalDateTime.now());
        travelRoute.setUpdatedAt(LocalDateTime.now());
        return travelRouteRepository.save(travelRoute);
    }

    @Override
    public TravelRoute get(String id) {
        
        return travelRouteRepository.findById(id).orElse(null);
    }

    @Override
    public TravelRoute update(TravelRoute travelRoute)
    {
        return travelRouteRepository.save(travelRoute);
    }

    @Override
    public TravelRoute delete(String id)
    {
        TravelRoute travelRoute = this.get(id);
        travelRouteRepository.deleteById(travelRoute.getId());
        return travelRoute;
    }

    @Override
    public List<TravelRoute> getAll()
    {
        return travelRouteRepository.findAll();
    }

    public void reloadDataBase()
    {
        dataFake.init();
    }
}
