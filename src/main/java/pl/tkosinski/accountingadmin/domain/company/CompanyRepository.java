package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.Common.BaseRepository;

import java.util.Optional;

interface CompanyRepository extends BaseRepository {

    CompanyDao save(CompanyDao companyDao);

    Optional<CompanyDao> get(long id);

    void delete(long id);

    int size();

    CompanyDao generate();

    CompanyDao generateAndSave();
}
