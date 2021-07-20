package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.Status;

public interface StatusService {
    Status findByStatus(String name);
    Status save(Status status);
}
