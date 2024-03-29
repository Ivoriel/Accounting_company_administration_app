package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}/get")
    public UserDto get(@PathVariable Long id) {
        return facade.get(id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        facade.delete(id);
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
