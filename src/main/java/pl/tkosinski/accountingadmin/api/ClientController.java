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
import pl.tkosinski.accountingadmin.domain.client.ClientFacade;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
class ClientController extends BaseController {

    private final ClientFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody ClientDto dto) {
        facade.save(dto);
    }

    @GetMapping("/{id}/get")
    public ClientDto get(@PathVariable Id id) {
        return facade.get(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody IdRequest request) {
        validateAdminOrEmployee(request.getUserId());

        facade.delete(request.getId());
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
