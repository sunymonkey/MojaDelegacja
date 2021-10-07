package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.DelegationCosts;
import pl.sunymonkey.mojadelegacja.model.StatementOfCosts;


public interface DelegationCostsService {
    DelegationCosts save(DelegationCosts delegationCosts);
    DelegationCosts calculateAndSave(StatementOfCosts statementOfCosts);
    DelegationCosts finishCalculateAndSave(StatementOfCosts statementOfCosts);

}
