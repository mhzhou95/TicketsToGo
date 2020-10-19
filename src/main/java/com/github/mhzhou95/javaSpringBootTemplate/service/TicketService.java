package com.github.mhzhou95.javaSpringBootTemplate.service;

import com.github.mhzhou95.javaSpringBootTemplate.model.Ticket;
import com.github.mhzhou95.javaSpringBootTemplate.model.User;
import com.github.mhzhou95.javaSpringBootTemplate.repository.TicketRepository;
import com.github.mhzhou95.javaSpringBootTemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Iterable<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket;
    }
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket delete(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        ticketRepository.deleteById(id);
        return ticket.get();
    }

    public Ticket editTicket(Long id, Ticket ticket) {

        // Check the optional to see if anything is present then get the user object out else break out of this method
        Optional<Ticket> findTicket = this.findById(id);

        // Check the optional to see if anything is present then get the user object out else break out of this method
        if (findTicket.isPresent()) {
//            User returnedUser = findUser.get();
            // Set the changeable fields to the new fields if any change
//            returnedUser.setFirstName(user.getFirstName());
//            returnedUser.setLastName(user.getLastName());
//            returnedUser.setEmail(user.getEmail());
//            returnedUser.setPassword(user.getPassword());
//            returnedUser.setPhoneNumber(user.getPhoneNumber());
//            returnedUser.setLastModified(Calendar.getInstance().getTime());
//            return userRepository.save(returnedUser);
            return ticketRepository.save(ticket);
        } else {
            return null;
        }
    }
}
