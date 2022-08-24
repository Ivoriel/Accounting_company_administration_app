package pl.tkosinski.accountingadmin.client;

public interface ClientService {

    Client save(Client client);

    Client get(Long id);

}
