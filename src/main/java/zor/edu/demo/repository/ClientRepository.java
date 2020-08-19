package zor.edu.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import zor.edu.demo.model.Client;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String>
{

}
