package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}/get")
    public AddressDto get(@PathVariable Long id) {
        return facade.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        facade.delete(id);
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
