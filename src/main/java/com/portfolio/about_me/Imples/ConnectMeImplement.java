package com.portfolio.about_me.Imples;

import com.portfolio.about_me.Dto.ConnectMeSaveDto;
import com.portfolio.about_me.Dto.ConnectionMeResponse;
import com.portfolio.about_me.Repository.ConnectMeRepo;
import com.portfolio.about_me.Service.ConnectMeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectMeImplement implements ConnectMeService {
    @Autowired
    private ConnectMeRepo connectMeRepo;@Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ConnectionMeResponse> getAllConnection() {
        return this.connectMeRepo.findAll().stream().map(e->this.modelMapper.map(e,ConnectionMeResponse.class)).collect(Collectors.toList());
    }

    @Override
    public boolean addConnection(ConnectMeSaveDto saveDto) {
        return false;
    }

    @Override
    public boolean updateConnectionById(ConnectMeSaveDto saveDto, int id) {
        return false;
    }

    @Override
    public boolean deleteConnectionById(int id) {
        return false;
    }
}
