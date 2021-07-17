package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.sunymonkey.mojadelegacja.model.DokumentDetails;
import pl.sunymonkey.mojadelegacja.repository.DokumentDetailsRepository;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;
import pl.sunymonkey.mojadelegacja.service.DokumentDetailsService;

import java.time.LocalDateTime;

public class DokumentDetailsServiceImpl implements DokumentDetailsService {

    private final DokumentDetailsRepository dokumentDetailsRepository;

    public DokumentDetailsServiceImpl(DokumentDetailsRepository dokumentDetailsRepository) {
        this.dokumentDetailsRepository = dokumentDetailsRepository;
    }

    @Override
    public DokumentDetails save(DokumentDetails dokumentDetails) {
        return dokumentDetailsRepository.save(dokumentDetails);
    }

    @Override
    public DokumentDetails newDokument(@AuthenticationPrincipal CurrentUser currentUser) {
        DokumentDetails dokumentDetails = new DokumentDetails();
        dokumentDetails.setAcceptUser(currentUser.getUser());
        dokumentDetails.setCreateDateTime(LocalDateTime.now());
        dokumentDetailsRepository.save(dokumentDetails);
        return dokumentDetails;
    }

    @Override
    public DokumentDetails acceptDokument(@AuthenticationPrincipal CurrentUser currentUser,
                                          DokumentDetails dokumentDetails) {
        dokumentDetails.setAcceptUser(currentUser.getUser());
        dokumentDetails.setAcceptDateTime(LocalDateTime.now());
        dokumentDetailsRepository.save(dokumentDetails);
        return dokumentDetails;
    }
}
