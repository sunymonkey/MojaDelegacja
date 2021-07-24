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
import pl.sunymonkey.mojadelegacja.service.StatusService;

import java.time.LocalDateTime;

@Service
@Transactional
public class DokumentDetailsServiceImpl implements DokumentDetailsService {

    private final DokumentDetailsRepository dokumentDetailsRepository;

    @Autowired
    EmailSender emailSender;

    @Autowired
    StatusService statusService;

    public DokumentDetailsServiceImpl(DokumentDetailsRepository dokumentDetailsRepository) {
        this.dokumentDetailsRepository = dokumentDetailsRepository;
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
        Status nowy = statusService.findByStatus("Nowy");
        dokumentDetails.setStatus(nowy);
        dokumentDetailsRepository.save(dokumentDetails);
        String content = "Stworzono nowy dokument przez " + currentUser.getUsername();
        emailSender.sendEmail("kokurek@interia.pl", "Stworzono nowy dokument", content);
        return dokumentDetails;
    }

    @Override
    public DokumentDetails acceptDokument(CurrentUser currentUser, DokumentDetails dokumentDetails) {
        dokumentDetails.setAcceptUser(currentUser.getUser());
        dokumentDetails.setAcceptDateTime(LocalDateTime.now());
        Status accept = statusService.findByStatus("Zaakceptowany");
        dokumentDetails.setStatus(accept);
        dokumentDetailsRepository.save(dokumentDetails);
        String content = "Zaakceptowany dokument przez " + currentUser.getUsername();
        emailSender.sendEmail("kokurek@interia.pl", "Dokument przesłany", content);
        return dokumentDetails;
    }

    @Override
    public DokumentDetails sendDokument(CurrentUser currentUser, DokumentDetails dokumentDetails) {
        dokumentDetails.setSendUser(currentUser.getUser());
        dokumentDetails.setSendDateTime(LocalDateTime.now());
        Status send = statusService.findByStatus("Wysłany");
        dokumentDetails.setStatus(send);
        dokumentDetailsRepository.save(dokumentDetails);
        String content = "Wysłano nowy dokument przez " + currentUser.getUsername();
        emailSender.sendEmail("kokurek@interia.pl", "Dokument przesłany", content);
        return dokumentDetails;
    }

    @Override
    public DokumentDetails rejectDokument(CurrentUser currentUser, DokumentDetails dokumentDetails) {
        dokumentDetails.setRejectUser(currentUser.getUser());
        dokumentDetails.setRejectDateTime(LocalDateTime.now());
        Status reject = statusService.findByStatus("Odmowa");
        dokumentDetails.setStatus(reject);
        dokumentDetailsRepository.save(dokumentDetails);
        String content = "Odrzucono dokument przez " + currentUser.getUsername();
        emailSender.sendEmail("kokurek@interia.pl", "Dokument przesłany", content);
        return dokumentDetails;
    }
}
