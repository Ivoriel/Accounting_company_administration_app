package pl.tkosinski.accountingadmin.domain.client;

import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

import java.util.Optional;

@Component
public class ClientFacade {

    ClientRepository clientRepository;

    public void save(ClientDto dto) {
        clientRepository.get(dto.getId()).ifPresentOrElse(it -> updateClient(it, dto), () -> createClient(dto));
    }

    public ClientDto get(Long id) {
        ClientDto dto = new ClientDto();
        Optional<ClientDao> daoOptional = clientRepository.get(id);
        if (Optional.ofNullable(daoOptional).isPresent()) {
            dto = ClientMapper.toDto(daoOptional.get());
        }
        return dto;
    }

    public void delete(Long id) {
        clientRepository.delete(id);
    }

    public ClientDto generate() {
        return ClientMapper.toDto(clientRepository.generate());
    }

    private void updateClient(ClientDao dao, ClientDto dto) {
        clientRepository.save(dao.edit(dto.getName(), dto.getAddressId()));
    }

    private void createClient(ClientDto dto) {
        clientRepository.save(new ClientDao(clientRepository.size(), dto.getName(), dto.getAddressId()));
    }
}
