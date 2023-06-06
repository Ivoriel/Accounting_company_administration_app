package pl.tkosinski.accountingadmin.domain.company;

import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

import java.util.Optional;

@Component
public class CompanyFacade {

    CompanyRepository repository;

    public void save(CompanyDto dto) {
        repository.get(dto.getId()).ifPresentOrElse(it -> updateCompany(it, dto), () -> createCompany(dto));
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

    private void updateCompany(CompanyDao dao, CompanyDto dto) {
        repository.save(dao.edit(dto.getName(), dto.getClientId(), dto.getAddressId()));
    }

    private void createCompany(CompanyDto dto) {
        repository.save(new CompanyDao(repository.size(), dto.getName(), dto.getClientId(), dto.getAddressId()));
    }
}
