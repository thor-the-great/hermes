package hermes.controller;

import hermes.QueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    @Autowired
    QueueProducer queueProducerService;

    @GetMapping("/sendmsg")
    public ResponseEntity<String> scheduleDataPull() {
        try {
            queueProducerService.produce("Notify");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
        String response = "ok";
        return ResponseEntity.ok(response);
    }
}
