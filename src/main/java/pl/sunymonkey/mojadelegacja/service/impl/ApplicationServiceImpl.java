package pl.sunymonkey.mojadelegacja.service.impl;

import org.springframework.stereotype.Service;
import pl.sunymonkey.mojadelegacja.exceptions.ApplicationFailedException;
import pl.sunymonkey.mojadelegacja.model.Application;
import pl.sunymonkey.mojadelegacja.model.dto.ApplicationDto;
import pl.sunymonkey.mojadelegacja.repository.ApplicationRepository;
import pl.sunymonkey.mojadelegacja.service.ApplicationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Optional<Application> findById(Long id) {
        return applicationRepository.findById(id);
    }

    @Override
    public Application save(ApplicationDto dto)  {
        if(dto.getCountry()==null || dto.getPurpose()==null
                || dto.getFromDate()==null || dto.getToDate()==null){
            throw new ApplicationFailedException("Application not correct");
        }

        Application application = new Application();
        application.setPurpose(dto.getPurpose());
        application.setFromDate(dto.getFromDate());
        application.setToDate(dto.getToDate());
        application.setCountry(dto.getCountry());
        application.setStatus("OPEN");
        application.setCreateDateTime(LocalDateTime.now());

        return applicationRepository.save(application);
    }
}
