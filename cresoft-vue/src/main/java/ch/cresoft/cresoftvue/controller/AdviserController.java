package ch.cresoft.cresoftvue.controller;

import ch.cresoft.cresoftvue.dto.AdviserDto;
import ch.cresoft.cresoftvue.service.AdviserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/adviser")
public class AdviserController {
    @Autowired
    private AdviserService adviserService;

    @GetMapping
    public ResponseEntity<List<AdviserDto>> read() {
        List<AdviserDto> adviserDtoList = adviserService.findAll();

        if(!adviserDtoList.isEmpty()){
            return ResponseEntity.ok(adviserDtoList);
        }

        return ResponseEntity.noContent().build();
    }
}
