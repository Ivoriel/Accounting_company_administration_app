package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tkosinski.accountingadmin.common.dto.IdRequest;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.UserFacade;
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
class UserController extends BaseController {

    private final UserFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody UserDto dto) {
        facade.save(dto);
    }

    @PostMapping("/edit-name")
    public void editName(@PathVariable Id id, @RequestBody FullName name) {
        facade.editName(id, name);
    }

    @GetMapping("/{id}/get")
    public UserDto get(@PathVariable Id id) {
        return facade.get(id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Id id) {
        facade.delete(id);
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

        facade.switchRoleToClient(request.getId());
    }

    @GetMapping("/generate")
    public UserDto generate() {
        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public UserDto generateAndSave() {
        return facade.generateAndSave();
    }
}
