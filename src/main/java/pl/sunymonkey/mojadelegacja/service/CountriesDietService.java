package pl.sunymonkey.mojadelegacja.service;

import pl.sunymonkey.mojadelegacja.model.CountriesDiet;

import java.util.List;

public interface CountriesDietService {
    CountriesDiet getById(Long id);

    List<CountriesDiet> findAll();
}
