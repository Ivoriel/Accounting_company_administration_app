package pl.tkosinski.accountingadmin.domain.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyRequest;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class CompanyFacade {

    private final CompanyRepository repository;

    public void save(CompanyRequest request) {
        repository.get(request.id()).ifPresentOrElse(it -> updateCompany(it, request), () -> createCompany(request));
    }

    public CompanyDto get(Id id) {
        return CompanyMapper.toDto(repository.get(id).orElseThrow(NoSuchElementException::new));
    }

    public CompanyDto getRequestedOrGenerateAndSave(Id id) {
        return CompanyMapper.toDto(repository.get(id).orElse(repository.generateAndSave()));
    }

    public void delete(Id id) {
        repository.delete(id);
    }

    public CompanyDto generate() {
        return CompanyMapper.toDto(repository.generate());
    }

    public CompanyDto generateAndSave() {
        return CompanyMapper.toDto(repository.generateAndSave());
    }

    private void updateCompany(CompanyDao dao, CompanyRequest request) {
        repository.save(dao.edit(request));
    }

    private void createCompany(CompanyRequest request) {
        repository.save(CompanyDao.builder()
                .id(Id.ofValue(repository.size()))
                .name(request.name())
                .clientId(request.clientId())
                .addressId(request.addressId())
                .build());
    }
}
