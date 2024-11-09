package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tkosinski.accountingadmin.common.dto.IdRequest;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

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
    public void generate() {
        facade.generate();
    }

    @GetMapping("/generate-and-save")
    public void generateAndSave() {
        facade.generateAndSave();
    }
}
