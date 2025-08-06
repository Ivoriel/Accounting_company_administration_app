package pl.tkosinski.accountingadmin.domain.client.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tkosinski.accountingadmin.common.api.BaseController;
import pl.tkosinski.accountingadmin.common.dto.IdRequest;
import pl.tkosinski.accountingadmin.domain.client.ClientFacade;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientRequest;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRoleDto;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
class ClientController extends BaseController {

    private final ClientFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody ClientRequest request) {
        validateAdminOrEmployee(request.userId());

        facade.save(request);
    }

    @GetMapping("/{id}/get")
    public ClientDto get(@RequestBody IdRequest request) {
        validateAuthorized(request.getUserId());

        return facade.get(request.getId());
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody IdRequest request) {
        validateAdminOrEmployee(request.getUserId());

        facade.delete(request.getId());
    }

    @GetMapping("/generate")
    public ClientDto generate(@RequestBody UserRoleDto request) {
        validateAdminOrEmployee(request);

        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public ClientDto generateAndSave(@RequestBody UserRoleDto request) {
        validateAdminOrEmployee(request);

        return facade.generateAndSave();
    }
}
