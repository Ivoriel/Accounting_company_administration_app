package pl.tkosinski.accountingadmin.domain.client;

import lombok.var;
import org.springframework.stereotype.Component;
import pl.kosinski.acaa_dao.Client.ClientDao;
import pl.kosinski.acaa_dao.Client.ClientRepository;
import pl.kosinski.acaa_dto.ClientDto;
import pl.tkosinski.accountingadmin.domain.address.AddressService;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

import java.util.Optional;

@Component
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    AddressService addressService;

    @Override
    public pl.kosinski.acaa_dto.ClientDto save(ClientDto clientDto) {
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
    public pl.kosinski.acaa_dto.ClientDto get(Long id) {
        pl.kosinski.acaa_dto.ClientDto dto = new pl.kosinski.acaa_dto.ClientDto();
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

    private pl.kosinski.acaa_dto.ClientDto toDto(ClientDao clientDao) {
        pl.kosinski.acaa_dto.ClientDto dto = new pl.kosinski.acaa_dto.ClientDto();
        dto.setId(clientDao.getId());
        dto.setName(clientDao.getName());
        dto.setAddressId(clientDao.getAddressId());
        return dto;
    }

}
