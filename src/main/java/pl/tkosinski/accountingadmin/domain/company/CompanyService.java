package pl.tkosinski.accountingadmin.domain.company;

import pl.kosinski.acaa_dao.Company.CompanyDao;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

public interface CompanyService {

    CompanyDto save(CompanyDto companyDto);

    CompanyDto get(Long id);

    void delete(Long id);

}
