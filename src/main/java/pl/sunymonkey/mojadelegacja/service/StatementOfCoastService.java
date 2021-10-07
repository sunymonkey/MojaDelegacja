package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.Application;
import pl.sunymonkey.mojadelegacja.model.Delegation;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;
import pl.sunymonkey.mojadelegacja.model.dto.StatementOfCostsDto;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;

import java.util.List;

public interface StatementOfCoastService {
    StatementOfCosts save(StatementOfCosts statementOfCosts);
    StatementOfCosts save(CurrentUser currentUser, StatementOfCostsDto dto);

    StatementOfCosts findById(long id);

    void sendDokument(StatementOfCosts statementOfCosts, CurrentUser currentUser);

    List<StatementOfCosts> allStatus(String status);

    void acceptDokument(StatementOfCosts statementOfCosts, CurrentUser currentUser);

    void rejectDokument(StatementOfCosts statementOfCosts, CurrentUser currentUser);

    List<StatementOfCosts> findByUser(String user);

    StatementOfCostsDto newApplication(Application application);

    StatementOfCostsDto newApplication(Delegation delegation);
}
