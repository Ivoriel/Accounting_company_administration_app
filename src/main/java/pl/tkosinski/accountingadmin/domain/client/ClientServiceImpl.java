package pl.tkosinski.accountingadmin.domain.client;

import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

import java.util.Optional;

@Component
public class ClientServiceImpl {

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
        return toDto(clientRepository.save(clientDao));
    }

    public ClientDto get(Long id) {
        ClientDto dto = new ClientDto();
        Optional<ClientDao> daoOptional = clientRepository.get(id);
        if (Optional.ofNullable(daoOptional).isPresent()) {
            dto = toDto(daoOptional.get());
        }
        return dto;
    }

    public void delete(Long id) {
        clientRepository.delete(id);
    }

    public ClientDto generate() {
        return toDto(clientRepository.generate());
    }

    private ClientDto toDto(ClientDao clientDao) {
        ClientDto dto = new ClientDto();
        dto.setId(clientDao.getId());
        dto.setName(clientDao.getName());
        dto.setAddressId(clientDao.getAddressId());
        return dto;
    }

}
