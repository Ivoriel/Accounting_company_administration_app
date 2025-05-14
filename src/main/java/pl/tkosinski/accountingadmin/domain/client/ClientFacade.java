package pl.tkosinski.accountingadmin.domain.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientRequest;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ClientFacade {

    private final ClientRepository clientRepository;

    public void save(ClientRequest request) {
        clientRepository.get(request.id()).ifPresentOrElse(it -> updateClient(it, request), () -> createClient(request));
    }

    public ClientDto get(Id id) {
        return ClientMapper.toDto(clientRepository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public ClientDto getRequestedOrGenerateAndSave(Id id) {
        return ClientMapper.toDto(clientRepository.get(id)
                .orElse(clientRepository.generateAndSave()));
    }

    public void delete(Id id) {
        clientRepository.delete(id);
    }

    public ClientDto generate() {
        return ClientMapper.toDto(clientRepository.generate());
    }

    public ClientDto generateAndSave() {
        return ClientMapper.toDto(clientRepository.generateAndSave());
    }

    private void updateClient(ClientEntity dao, ClientRequest request) {
        clientRepository.save(dao.edit(request));
    }

    private void createClient(ClientRequest request) {
        clientRepository.save(new ClientEntity(Id.generate(), request));
    }
}
