package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.client.ClientFacade;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
class ClientController {

    private final ClientFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody ClientDto dto) {
        facade.save(dto);
    }

    @GetMapping("/{id}/get")
    public ClientDto get(@PathVariable Id id) {
        return facade.get(id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Id id) {
        facade.delete(id);
    }

    @GetMapping("/generate")
    public ClientDto generate() {
        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public ClientDto generateAndSave() {
        return facade.generateAndSave();
    }
}
