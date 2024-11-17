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
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;
import pl.tkosinski.accountingadmin.domain.user.dto.UserIdDto;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
class AddressController extends BaseController {

    private final AddressFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody AddressDto dto) {
        facade.save(dto);
    }

    @GetMapping("/{id}")
    public AddressDto get(@PathVariable Id id) {
        return facade.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody IdRequest request) {
        validateAdminOrEmployee(request.getUserId());

        facade.delete(request.getId());
    }

    @GetMapping("/generate")
    public AddressDto generate() {
        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public AddressDto generateAndSave() {
        return facade.generateAndSave();
    }
}
