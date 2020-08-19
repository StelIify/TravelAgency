package zor.edu.demo.service.client.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zor.edu.demo.datastorage.DataFake;
import zor.edu.demo.model.Client;
import zor.edu.demo.repository.ClientRepository;
import zor.edu.demo.service.client.interfaces.IClientService;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ClientServiceImpl implements IClientService
{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DataFake dataFake;

    @Override
    public Client create(Client client)
    {
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        return clientRepository.save(client);
    }

    @Override
    public Client get(String id)
    {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client update(Client client)
    {
        client.setUpdatedAt(LocalDateTime.now());
        return clientRepository.save(client);
    }

    @Override
    public Client delete(String id)
    {
        Client client = this.get(id);
        clientRepository.deleteById(client.getId());
        return client;
    }

    @Override
    public List<Client> getAll()
    {
        return clientRepository.findAll();
    }

    public void reloadDataBase()
    {
        dataFake.init();
    }
}
