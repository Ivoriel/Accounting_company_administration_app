package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody AddressDto dto) {
        facade.save(dto);
    }

    @GetMapping("/{id}")
    public AddressDto get(@PathVariable Long id) {
        return facade.get(Id.ofValue(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        facade.delete(Id.ofValue(id));
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
