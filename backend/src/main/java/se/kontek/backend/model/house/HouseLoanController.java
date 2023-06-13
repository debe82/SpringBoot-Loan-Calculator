package se.kontek.backend.model.house;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/house")
@CrossOrigin(origins = "*")
public class HouseLoanController {

    @Autowired
    HouseLoanService service;

    @GetMapping
    ResponseEntity<String> justGet(){
        String plan = "House Loan Page!";
        return ResponseEntity.ok().body(plan);
    }

    @PostMapping
    ResponseEntity<String> getPlan(@RequestBody HouseLoanDto houseLoanDto, HttpServletRequest req){
        String plan = service.getPlan(houseLoanDto);
        if (plan == null) return ResponseEntity.badRequest().build();
        System.out.println("olan: " + plan);
        return ResponseEntity.ok().body(plan);
    }
}
