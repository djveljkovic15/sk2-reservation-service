package database.reservation.service;

import database.reservation.domain.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation save(Reservation reservation);

    Reservation update(Long id, Reservation reservation);

    void deleteById(Long id);

    Reservation findById(Long id);

    List<Reservation> findAll();
}
