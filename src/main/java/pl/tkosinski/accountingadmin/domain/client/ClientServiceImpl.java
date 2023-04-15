package pl.tkosinski.accountingadmin.domain.client;

import lombok.var;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.address.AddressService;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

import java.util.Optional;

@Component
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    AddressService addressService;

    @Override
    public ClientDto save(ClientDto clientDto) {
        Optional<ClientDao> clientDaoOptional = clientRepository.get(clientDto.getId());
        if (Optional.ofNullable(clientDaoOptional).isPresent()) {
            var clientDao = clientDaoOptional.get();
            clientDao.edit(clientDto.getName(), clientDto.getAddressId());
            return toDto(clientRepository.save(clientDao));
        } else {
            var clientDao = new ClientDao(clientRepository.size(), clientDto.getName(), clientDto.getAddressId());
            return toDto(clientRepository.save(clientDao));
        }
    }

    @Override
    public ClientDto get(Long id) {
        ClientDto dto = new ClientDto();
        Optional<ClientDao> daoOptional = clientRepository.get(id);
        if (Optional.ofNullable(daoOptional).isPresent()) {
            dto = toDto(daoOptional.get());
        }
        return dto;
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(id);
    }

    private ClientDto toDto(ClientDao clientDao) {
        ClientDto dto = new ClientDto();
        dto.setId(clientDao.getId());
        dto.setName(clientDao.getName());
        dto.setAddressId(clientDao.getAddressId());
        return dto;
    }

}
