package com.hillcrest.HillcrestBackend.Controllers;

import com.hillcrest.HillcrestBackend.Services.StateUniversityStudentMapDTO;
import com.hillcrest.HillcrestBackend.Services.UniversityStudentMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4/states")
public class UniversityStudentMapController {

    private final UniversityStudentMapService universityStudentMapService;

    @Autowired
    public UniversityStudentMapController(UniversityStudentMapService universityStudentMapService) {
        this.universityStudentMapService = universityStudentMapService;
    }

    /**
     * Get a state with a map of its universities to their students
     *
     * @param stateName The name of the state
     * @return State with university-student map or 404 if not found
     */
    @GetMapping("/getState/{stateName}")
    public ResponseEntity<StateUniversityStudentMapDTO> getStateWithUniversityStudentMap(
            @PathVariable String stateName) {
        System.out.println("CALLED: " + stateName);

        return universityStudentMapService.getStateWithUniversityStudentMap(stateName)
                .map(result -> {
                    StateUniversityStudentMapDTO dto =
                            new StateUniversityStudentMapDTO(
                                    result.getState(),
                                    result.getUniversityStudentMap());
                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}