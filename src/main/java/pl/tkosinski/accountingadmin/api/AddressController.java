package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.tkosinski.accountingadmin.domain.address.AddressFacade;
import pl.tkosinski.accountingadmin.domain.address.dto.AddressDto;

@Controller
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressFacade facade;

    @PostMapping("/save")
    public void save(@RequestParam AddressDto dto) {
        facade.save(dto);
    }

    @GetMapping("/${id}/get")
    public AddressDto get(@PathVariable Long id) {
        return facade.get(id);
    }

    @DeleteMapping("/${id}")
    public void delete(@PathVariable Long id) {
        facade.delete(id);
    }

    @GetMapping("/generate")
    public void generate() {
        facade.generate();
    }
}
