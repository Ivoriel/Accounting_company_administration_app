package pl.tkosinski.accountingadmin.domain.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class CompanyFacade {

    private final CompanyRepository repository;

    public void save(CompanyDto dto) {
        repository.get(dto.getId()).ifPresentOrElse(it -> updateCompany(it, dto), () -> createCompany(dto));
    }

    public CompanyDto get(Id id) {
        return CompanyMapper.toDto(repository.get(id).orElseThrow(NoSuchElementException::new));
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

    private void updateCompany(CompanyDao dao, CompanyDto dto) {
        repository.save(dao.edit(dto.getName(), dto.getClientId(), dto.getAddressId()));
    }

    private void createCompany(CompanyDto dto) {
        repository.save(CompanyDao.builder()
                .id(Id.ofValue(repository.size()))
                .name(dto.getName())
                .clientId(dto.getClientId())
                .addressId(dto.getAddressId())
                .build());
    }
}
