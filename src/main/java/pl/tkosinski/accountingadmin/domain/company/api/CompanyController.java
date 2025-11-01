package pl.tkosinski.accountingadmin.domain.company.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tkosinski.accountingadmin.common.api.BaseController;
import pl.tkosinski.accountingadmin.common.dto.IdRequest;
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyRequest;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
class CompanyController extends BaseController {

    private final CompanyFacade facade;

    @PostMapping("save")
    public void save(@RequestBody CompanyRequest request) {
        validateAdminOrEmployee(request.userId());

        facade.save(request);
    }

    @GetMapping()
    public CompanyDto get(@RequestBody IdRequest request) {
        validateAuthorized(request.getUserId());

        return facade.get(request.getId());
    }

    @DeleteMapping("delete")
    public void delete(@RequestBody IdRequest request) {
        validateAdminOrEmployee(request.getUserId());

        facade.delete(request.getId());
    }

    @GetMapping("generate")
    public CompanyDto generate(@RequestBody UserRoleDto request) {
        validateAdminOrEmployee(request);

        return facade.generate();
    }

    @GetMapping("generate-and-save")
    public CompanyDto generateAndSave(@RequestBody UserRoleDto request) {
        validateAdminOrEmployee(request);

        return facade.generateAndSave();
    }
}
