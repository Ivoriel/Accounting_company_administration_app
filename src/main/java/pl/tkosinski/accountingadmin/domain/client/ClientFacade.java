package pl.tkosinski.accountingadmin.domain.client;

import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

import java.util.Optional;

@Component
public class ClientFacade {

    ClientRepository clientRepository;

    public ClientDto save(ClientDto clientDto) {
        Optional<ClientDao> clientDaoOptional = clientRepository.get(clientDto.getId());
        ClientDao clientDao;
        if (Optional.ofNullable(clientDaoOptional).isPresent()) {
            clientDao = clientDaoOptional.get();
            clientDao.edit(clientDto.getName(), clientDto.getAddressId());
        } else {
            clientDao = new ClientDao(clientRepository.size(), clientDto.getName(), clientDto.getAddressId());
        }
        return ClientMapper.toDto(clientRepository.save(clientDao));
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

}
