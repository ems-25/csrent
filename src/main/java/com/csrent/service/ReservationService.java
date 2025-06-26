package com.csrent.service;

import com.csrent.Dto.ReservationDto;
import com.csrent.model.Reservation;
import com.csrent.model.Space;
import com.csrent.model.User;
import com.csrent.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService
{
    @Autowired
    private ReservationRepository reservationRepository;
    private UserService userService;
    private SpaceService spaceService;

    public ReservationService(ReservationRepository reservationRepository, UserService userService, SpaceService spaceService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.spaceService = spaceService;
    }

    public List<Reservation> getAll ()
    {
        return reservationRepository.findAll();
    }

    public Reservation add(ReservationDto reservationDto) {
        User user = userService.getUserByEmail(reservationDto.getEmailUser());
        Space space = spaceService.getSpace(reservationDto.getIdSpace());
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setSpace(space);
        reservation.setDateReservation(reservationDto.getDate());
        reservation.setStatus(reservationDto.getStatus());
        return reservationRepository.save(reservation);
    }

    // /////////////////////// ELIMINAR RESERVA /////////////////

    public Reservation deleteReserve(Integer id)
    {
        Reservation localClass = reservationRepository.findById(id).get();

        if (localClass != null)
        {
            reservationRepository.deleteById(id);

            return localClass;
        }

        return localClass;


    }//deleteReserve

    // /////////////////////// FIN DEL METODO //////////////////////

    // /////////////////////// BUSCAR RESERVA /////////////////
    public Reservation searchReserve(Integer id)
    {
        return reservationRepository.findById(id).get();
    }

    // /////////////////////// FIN DEL METODO //////////////////////


    // /////////////////////// EDITAR ALGO ESPECIFICO DE LA RESERVA /////////////////
    public Reservation editPatchReserve(Reservation reserve)
    {
        Optional<Reservation> reserveExist = reservationRepository.findById(reserve.getId());

        if (reserveExist.isPresent()) {
            Reservation reserveBd = reserveExist.get();
            if (reserve.getDateReservation() != null) {
                reserveBd.setDateReservation(reserve.getDateReservation());
            }
            if (reserve.getStatus() != null)
            {
                reserveBd.setStatus(reserve.getStatus());
            }



            return reservationRepository.save(reserveBd);
        }
        return reserve;

    }//editPatchReserve

    // /////////////////////// FIN DEL METODO //////////////////////

}
