package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tkosinski.accountingadmin.common.dto.IdRequest;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;
import pl.tkosinski.accountingadmin.domain.user.dto.UserIdDto;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
class CompanyController extends BaseController{

    private final CompanyFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody CompanyDto dto) {
        validateAdminOrEmployee(dto.userId());

        facade.save(dto);
    }

    @GetMapping("/{id}/get")
    public CompanyDto get(@PathVariable Id id) {
        return facade.get(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody IdRequest request) {
        validateAdminOrEmployee(request.getUserId());

        facade.delete(request.getId());
    }

    @GetMapping("/generate")
    public CompanyDto generate(@RequestBody UserIdDto request) {
        validateAdminOrEmployee(request);

        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public CompanyDto generateAndSave(@RequestBody UserIdDto request) {
        validateAdminOrEmployee(request);

        return facade.generateAndSave();
    }
}
