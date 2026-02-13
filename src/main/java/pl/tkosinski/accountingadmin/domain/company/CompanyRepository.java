package pl.tkosinski.accountingadmin.domain.company;

import pl.tkosinski.accountingadmin.common.BaseRepository;
import pl.tkosinski.accountingadmin.common.model.Id;

import java.util.Optional;

interface CompanyRepository extends BaseRepository<CompanyEntity> {

    CompanyEntity save(CompanyEntity entity);

    Optional<CompanyEntity> get(Id id);

    void delete(Id id);

    int size();

    CompanyEntity generate();

    CompanyEntity generateAndSave();
}
