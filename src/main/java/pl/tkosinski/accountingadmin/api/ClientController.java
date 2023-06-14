package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.tkosinski.accountingadmin.domain.client.ClientFacade;
import pl.tkosinski.accountingadmin.domain.client.dto.ClientDto;

@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientFacade facade;

    @PostMapping("/save")
    public void save(@RequestParam ClientDto dto) {
        facade.save(dto);
    }
}
