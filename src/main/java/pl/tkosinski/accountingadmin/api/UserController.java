package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tkosinski.accountingadmin.common.dto.IdRequest;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.UserFacade;
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;
import pl.tkosinski.accountingadmin.domain.user.dto.UserIdDto;
import pl.tkosinski.accountingadmin.domain.user.dto.UserRequest;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
class UserController extends BaseController {

    private final UserFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody UserRequest request) {
        validateAdminOrEmployee(request.userId());

        facade.save(request);
    }

    @PostMapping("/edit-name")
    public void editName(@PathVariable Id id, @RequestBody FullName name) {
        facade.editName(id, name);
    }

    @GetMapping("/{id}/get")
    public UserDto get(@PathVariable Id id) {
        return facade.get(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody IdRequest request) {
        validateAdmin(request.getUserId());

        facade.delete(request.getId());
    }

    @PutMapping("/switch-role-employee")
    public void switchRoleToEmployee(@RequestBody IdRequest request) {
        validateAdmin(request.getUserId());

        facade.switchRoleToEmployee(request.getId());
    }

    @PutMapping("/switch-role-client")
    public void switchRoleToClient(@RequestBody IdRequest request) {
        validateAdmin(request.getUserId());

        facade.switchRoleToClient(request.getId());
    }

    @PutMapping("/switch-role-admin")
    public void switchRoleToAdmin(@RequestBody IdRequest request) {
        validateAdmin(request.getUserId());

        facade.switchRoleToAdmin(request.getId());
    }

    @GetMapping("/generate")
    public UserDto generate(@RequestBody UserIdDto request) {
        validateAdminOrEmployee(request);

        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public UserDto generateAndSave(@RequestBody UserIdDto request) {
        validateAdminOrEmployee(request);

        return facade.generateAndSave();
    }
}
