package database.reservation.service.impl;

import database.reservation.domain.Reservation;
import database.reservation.repositorium.ReservationRepository;
import database.reservation.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    public ReservationServiceImpl(ReservationRepository repository) {
        this.repository = repository;
    }


    @Override
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        if(findById(id)==null)
            return null;
        reservation.setId(id);
        return repository.save(reservation);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Reservation findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findAll() {
        return repository.findAll();
    }
}
