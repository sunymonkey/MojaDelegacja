package pl.sunymonkey.mojadelegacja.service;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.sunymonkey.mojadelegacja.model.DokumentDetails;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;


public interface DokumentDetailsService {
    DokumentDetails save(DokumentDetails dokumentDetails);
    DokumentDetails newDokument(@AuthenticationPrincipal CurrentUser currentUser);
    DokumentDetails acceptDokument(@AuthenticationPrincipal CurrentUser currentUser,
                                   DokumentDetails dokumentDetails);

}
