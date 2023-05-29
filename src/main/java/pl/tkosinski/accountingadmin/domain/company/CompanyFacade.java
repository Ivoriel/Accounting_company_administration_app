package pl.tkosinski.accountingadmin.domain.company;

import lombok.var;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

import java.util.Optional;

@Component
public class CompanyFacade {

    CompanyRepository repository;

    public CompanyDto save(CompanyDto companyDto) {
        Optional<CompanyDao> companyDaoOptional = repository.get(companyDto.getId());
        CompanyDao companyDao;
        if (Optional.ofNullable(companyDaoOptional).isPresent()) {
            companyDao = companyDaoOptional.get();
            companyDao.edit(companyDto.getName(), companyDto.getClientId(),
                    companyDto.getAddressId());
        } else {
            companyDao = new CompanyDao(repository.size(), companyDto.getName(), companyDto.getClientId(),
                    companyDto.getAddressId());
        }
        return CompanyMapper.toDto(repository.save(companyDao));
    }

    public CompanyDto get(Long id) {
        var companyDto = new CompanyDto();
        var companyDaoOptional = repository.get(id);
        if (Optional.ofNullable(companyDaoOptional).isPresent()) {
            companyDto = CompanyMapper.toDto(companyDaoOptional.get());
        }
        return companyDto;
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public CompanyDao generate() {
        return repository.generate();
    }
}
