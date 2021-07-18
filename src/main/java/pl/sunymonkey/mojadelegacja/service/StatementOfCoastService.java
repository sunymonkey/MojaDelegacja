package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;
import pl.sunymonkey.mojadelegacja.model.dto.StatementOfCostsDto;
import pl.sunymonkey.mojadelegacja.security.CurrentUser;

public interface StatementOfCoastService {
    StatementOfCosts save(StatementOfCosts statementOfCosts);
    StatementOfCosts save(CurrentUser currentUser, StatementOfCostsDto dto);

}
