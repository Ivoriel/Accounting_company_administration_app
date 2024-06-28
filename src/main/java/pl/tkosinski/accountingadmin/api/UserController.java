package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tkosinski.accountingadmin.common.model.FullName;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.user.UserFacade;
import pl.tkosinski.accountingadmin.domain.user.dto.UserDto;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

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
    public void switchRoleToEmployee(@PathVariable Id id) {
        facade.switchRoleToEmployee(id);
    }

    @PutMapping("/switch-role-client")
    public void switchRoleToClient(@PathVariable Id id) {
        facade.switchRoleToClient(id);
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
