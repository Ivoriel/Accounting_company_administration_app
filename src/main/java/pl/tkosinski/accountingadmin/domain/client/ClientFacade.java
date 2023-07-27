package pl.tkosinski.accountingadmin.domain.client;

import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

import java.util.NoSuchElementException;

@Component
public class ClientFacade {

    ClientRepository clientRepository;

    public void save(ClientDto dto) {
        clientRepository.get(dto.getId()).ifPresentOrElse(it -> updateClient(it, dto), () -> createClient(dto));
    }

    public ClientDto get(Long id) {
        return ClientMapper.toDto(clientRepository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public void delete(Long id) {
        clientRepository.delete(id);
    }

    public ClientDto generate() {
        return ClientMapper.toDto(clientRepository.generate());
    }

    public ClientDto generateAndSave() {
        return ClientMapper.toDto(clientRepository.generateAndSave());
    }

    private void updateClient(ClientDao dao, ClientDto dto) {
        clientRepository.save(dao.edit(dto.getName(), dto.getAddressId()));
    }

    private void createClient(ClientDto dto) {
        clientRepository.save(ClientDao.builder()
                .id(clientRepository.size())
                .name(dto.getName())
                .addressId(dto.getAddressId())
                .build());
    }
}
