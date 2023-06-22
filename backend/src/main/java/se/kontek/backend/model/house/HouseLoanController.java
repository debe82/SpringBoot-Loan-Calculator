package se.kontek.backend.model.house;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/house")
@CrossOrigin(origins = "http://localhost:4200")
public class HouseLoanController {
    Logger log = Logger.getLogger(HouseLoanController.class.getName());
    @Autowired
    HouseLoanService service;

    @GetMapping
    ResponseEntity<String> justGet(){
        String plan = "House Loan Page!";
        return ResponseEntity.ok().body(plan);
    }

    @PostMapping
    ResponseEntity<String> getPlan(@RequestBody HouseLoanDto houseLoanDto, HttpServletRequest req){
        String plan = service.getMonthlyPayment(houseLoanDto);
        if (plan == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(plan);
    }
}
