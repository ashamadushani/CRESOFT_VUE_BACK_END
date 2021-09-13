package ch.cresoft.cresoftvue.service.impl;

import ch.cresoft.cresoftvue.dao.AdviserDao;
import ch.cresoft.cresoftvue.dto.AdviserDto;
import ch.cresoft.cresoftvue.model.Adviser;
import ch.cresoft.cresoftvue.service.AdviserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Transactional
@Service
public class AdviserServiceImpl implements AdviserService {
    @Autowired
    private AdviserDao adviserDao;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<AdviserDto> findAll() {
        List<Adviser> advisers = adviserDao.findAll();

        return StreamSupport.stream(advisers.spliterator(), false)
                .map(this::getAdviserDto)
                .collect(Collectors.toList());
    }

    private AdviserDto getAdviserDto(Adviser adviser){
        return mapper.map(adviser, AdviserDto.class);
    }
}
