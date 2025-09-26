package pl.tkosinski.accountingadmin.domain.address.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tkosinski.accountingadmin.common.api.BaseController;
import pl.tkosinski.accountingadmin.common.dto.IdRequest;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressRequest;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
class AddressController extends BaseController {

    private final AddressFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody AddressRequest request) {
        validateAuthorized(request.userId());

        facade.save(request);
    }

    @GetMapping()
    public AddressDto get(@RequestBody IdRequest request) {
        validateAuthorized(request.getUserId());

        return facade.get(request.getId());
    }

    @DeleteMapping()
    public void delete(@RequestBody IdRequest request) {
        validateAdminOrEmployee(request.getUserId());

        facade.delete(request.getId());
    }

    @GetMapping("generate")
    public AddressDto generate(@RequestBody UserRoleDto request) {
        validateAdminOrEmployee(request);

        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public AddressDto generateAndSave(@RequestBody UserRoleDto request) {
        validateAdminOrEmployee(request);

        return facade.generateAndSave();
    }
}
