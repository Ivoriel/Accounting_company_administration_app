package pl.tkosinski.accountingadmin.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tkosinski.accountingadmin.common.dto.IdRequest;
import pl.tkosinski.accountingadmin.common.model.Id;
import pl.tkosinski.accountingadmin.domain.task.TaskFacade;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskAssignmentDto;
import pl.tkosinski.accountingadmin.domain.task.dto.TaskDto;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
class TaskController extends BaseController{

    private final TaskFacade facade;

    @PostMapping("/save")
    public void save(@RequestBody TaskDto dto) {
        facade.save(dto);
    }

    @GetMapping("/{id}/get")
    public TaskDto get(@PathVariable Id id) {
        return facade.get(id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Id id) {
        facade.delete(id);
    }

    @GetMapping("/generate")
    public TaskDto generate() {
        return facade.generate();
    }

    @GetMapping("/generate-and-save")
    public TaskDto generateAndSave() {
        return facade.generateAndSave();
    }

    @PostMapping("/assign")
    public void assign(@RequestBody TaskAssignmentDto dto) {
        facade.assignTask(dto);
    }

    @PostMapping("/begin")
    public void begin(@RequestBody IdRequest request) {
        validateEmployee(request.getUserId());

        facade.beginTask(request.getId());
    }

    @PostMapping("/finish")
    public void finish(@RequestBody IdRequest request) {
        validateAdminOrEmployee(request.getUserId());

        facade.finishTask(request.getId());
    }
}
