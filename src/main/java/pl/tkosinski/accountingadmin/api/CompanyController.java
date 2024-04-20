package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.company.CompanyFacade;
import pl.tkosinski.accountingadmin.domain.company.dto.CompanyDto;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody CompanyDto dto) {
        facade.save(dto);
    }

    @GetMapping("/{id}/get")
    public CompanyDto get(@PathVariable Id id) {
        return facade.get(id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Id id) {
        facade.delete(id);
    }

    @GetMapping("/generate")
    public CompanyDto generate() {
        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public CompanyDto generateAndSave() {
        return facade.generateAndSave();
    }
}
