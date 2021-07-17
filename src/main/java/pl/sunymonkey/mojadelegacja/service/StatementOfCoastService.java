package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;
import pl.sunymonkey.mojadelegacja.model.dto.StatementOfCostsDto;

public interface StatementOfCoastService {
    StatementOfCosts save(StatementOfCosts statementOfCosts);
    StatementOfCosts save(StatementOfCostsDto dto);

}
