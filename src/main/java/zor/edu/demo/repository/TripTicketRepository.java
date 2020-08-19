package zor.edu.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import zor.edu.demo.model.TravelRoute;
import zor.edu.demo.model.TripTicket;

import java.util.List;

@Repository
public interface TripTicketRepository extends MongoRepository<TripTicket, String>
{

}
