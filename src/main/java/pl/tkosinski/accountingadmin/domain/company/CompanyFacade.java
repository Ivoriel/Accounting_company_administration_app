package pl.tkosinski.accountingadmin.domain.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;
import pl.tkosinski.accountingadmin.domain.client.ClientFacade;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyRequest;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class CompanyFacade {

    private final CompanyRepository repository;
    private final AddressFacade addressFacade;
    private final ClientFacade clientFacade;

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
        return new CompanyGenerator().generate(clientFacade, addressFacade);
    }

    public CompanyDto generateAndSave() {
        return CompanyMapper.toDto(repository.save(CompanyMapper.toDao(generate())));
    }

    private void updateCompany(CompanyEntity dao, CompanyRequest request) {
        repository.save(dao.edit(request));
    }

    private void createCompany(CompanyRequest request) {
        repository.save(new CompanyEntity(request));
    }
}
