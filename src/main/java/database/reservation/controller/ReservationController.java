package database.reservation.controller;


import io.swagger.annotations.ApiOperation;
import database.reservation.domain.Reservation;
import database.reservation.service.ReservationService;
import database.token.security.CheckSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("service/film")
public class ReservationController {
    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }


    @CheckSecurity(roles = {"ADMIN"})
    @PostMapping("/save")
    @ApiOperation(value = "Save reservation.")
    public ResponseEntity<Reservation> save(@RequestHeader("Authorization") String authorization,
                                            @Valid @RequestBody Reservation reservation){
        return new ResponseEntity<>(service.save(reservation), HttpStatus.CREATED);
    }


    @CheckSecurity(roles = {"ADMIN"})
    @PostMapping("/update/{reservationId}")
    @ApiOperation(value = "update reservation.")
    public ResponseEntity<Reservation> update(@RequestHeader("Authorization") String authorization,
                                              @PathVariable Long reservationId, @Valid @RequestBody Reservation reservation){
        return new ResponseEntity<>(service.update(reservationId, reservation), HttpStatus.CREATED);
    }

    @CheckSecurity(roles = {"ADMIN"})
    @DeleteMapping("/delete/{reservationId}")
    @ApiOperation(value = "Deletes reservation.")
    public ResponseEntity<?> deleteById(@RequestHeader("Authorization") String authorization,
                                        @PathVariable Long reservationId){
        service.deleteById(reservationId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @CheckSecurity(roles = {"ADMIN"})
    @GetMapping("/{reservationId}")
    @ApiOperation(value = "Finds reservation by id.")
    public ResponseEntity<Reservation> findById(@RequestHeader("Authorization") String authorization,
                                                @PathVariable Long reservationId){
        return new ResponseEntity<>(service.findById(reservationId), HttpStatus.OK);
    }


    @CheckSecurity(roles = {"ADMIN","REGULAR"})
    @GetMapping("/all")
    @ApiOperation(value = "Finds all reservations.")
    public List<Reservation> findAll(@RequestHeader("Authorization") String authorization){
        return service.findAll();
    }

}
