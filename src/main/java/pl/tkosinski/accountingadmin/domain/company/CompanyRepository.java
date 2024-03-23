package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.Optional;

interface CompanyRepository extends BaseRepository<CompanyDao> {

    CompanyDao save(CompanyDao companyDao);

    Optional<CompanyDao> get(Id id);

    void delete(Id id);

    int size();

    CompanyDao generate();

    CompanyDao generateAndSave();
}
