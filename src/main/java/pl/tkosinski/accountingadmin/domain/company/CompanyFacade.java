package pl.tkosinski.accountingadmin.domain.company;

import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

import java.util.NoSuchElementException;

@Component
public class CompanyFacade {

    CompanyRepository repository;

    public void save(CompanyDto dto) {
        repository.get(dto.getId()).ifPresentOrElse(it -> updateCompany(it, dto), () -> createCompany(dto));
    }

    public CompanyDto get(Long id) {
        return CompanyMapper.toDto(repository.get(id).orElseThrow(NoSuchElementException::new));
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
