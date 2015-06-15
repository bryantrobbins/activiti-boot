package aboot.controllers

import aboot.model.TicketRequest
import aboot.model.TicketRequestRepository
import org.activiti.engine.RuntimeService
import org.activiti.engine.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

/**
 * Created by bryan on 6/14/15.
 */
@RestController
public class TicketRequestController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TicketRequestRepository ticketRequestRepository;

    @RequestMapping(value = "/ticket", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void startTicketRequest(@RequestBody Map<String, String> data) {

        TicketRequest ticketRequest = new TicketRequest(summary: data.get("summary"), notes: data.get("notes"),
                assignee: data.get("assignee"), templateId: data.get("templateId"));
        ticketRequestRepository.save(ticketRequest);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("request", ticketRequest);
        runtimeService.startProcessInstanceByKey("hireProcessWithJpa", variables);
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void viewTicketRequest(@PathVariable long ticketRequestId) {
        ticketRequestRepository.getOne(ticketRequestId)
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void resetFailedRequests() {
        taskService.createTaskQuery().taskName("Waiting for Reset").list().each { task ->
            taskService.complete(task.id)
        }
    }
}
