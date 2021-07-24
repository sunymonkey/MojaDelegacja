package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.model.CountriesDiet;
import pl.sunymonkey.mojadelegacja.repository.CountriesDietRepository;
import pl.sunymonkey.mojadelegacja.service.CountriesDietService;

import java.util.List;

@Service
public class CountriesDietServiceImpl implements CountriesDietService {

    private final CountriesDietRepository countriesDietRepository;

    public CountriesDietServiceImpl(CountriesDietRepository countriesDietRepository) {
        this.countriesDietRepository = countriesDietRepository;
    }

    @Override
    public CountriesDiet getById(Long id) {
        return countriesDietRepository.getById(id);
    }

    @Override
    public List<CountriesDiet> findAll() {
        return countriesDietRepository.findAll();
    }
}
