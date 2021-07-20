package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sunymonkey.mojadelegacja.model.DokumentDetails;
import pl.sunymonkey.mojadelegacja.model.Status;
import pl.sunymonkey.mojadelegacja.repository.DokumentDetailsRepository;
import pl.sunymonkey.mojadelegacja.repository.StatusRepository;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;
import pl.sunymonkey.mojadelegacja.service.DokumentDetailsService;
import pl.sunymonkey.mojadelegacja.service.EmailSender;

import java.time.LocalDateTime;

@Service
public class DokumentDetailsServiceImpl implements DokumentDetailsService {

    private final DokumentDetailsRepository dokumentDetailsRepository;

    private final StatusRepository statusRepository;

    @Autowired
    EmailSender emailSender;

    public DokumentDetailsServiceImpl(DokumentDetailsRepository dokumentDetailsRepository, StatusRepository statusRepository) {
        this.dokumentDetailsRepository = dokumentDetailsRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public DokumentDetails save(DokumentDetails dokumentDetails) {
        return dokumentDetailsRepository.save(dokumentDetails);
    }

    @Override
    public DokumentDetails newDokument(CurrentUser currentUser) {
        DokumentDetails dokumentDetails = new DokumentDetails();
        dokumentDetails.setCreateUser(currentUser.getUser());
        dokumentDetails.setCreateDateTime(LocalDateTime.now());
        String content = "Stworzono nowy dokument przez " + currentUser.getUsername();
        emailSender.sendEmail("kokurek@interia.pl", "Stworzono nowy dokument", content);
        dokumentDetailsRepository.save(dokumentDetails);

        Status nowy = statusRepository.findByStatus("Nowy");
        dokumentDetails.setStatus(nowy);

        return dokumentDetails;
    }

    @Override
    public DokumentDetails acceptDokument(CurrentUser currentUser, DokumentDetails dokumentDetails) {
        dokumentDetails.setAcceptUser(currentUser.getUser());
        dokumentDetails.setAcceptDateTime(LocalDateTime.now());
        dokumentDetailsRepository.save(dokumentDetails);
        return dokumentDetails;
    }
}
