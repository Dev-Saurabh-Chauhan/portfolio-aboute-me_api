package com.portfolio.about_me.Imples;

import com.portfolio.about_me.Dto.ConnectMeSaveDto;
import com.portfolio.about_me.Dto.ConnectionMeResponse;
import com.portfolio.about_me.Repository.ConnectMeRepo;
import com.portfolio.about_me.Service.ConnectMeService;
import com.portfolio.about_me.entity.ConnectMe;
import com.portfolio.about_me.exceptions.DataNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConnectMeImplement implements ConnectMeService {
    @Autowired
    private ConnectMeRepo connectMeRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ConnectionMeResponse> getAllConnection() {
        return this.connectMeRepo.findAll().stream().map(e -> this.modelMapper.map(e, ConnectionMeResponse.class)).collect(Collectors.toList());
    }

    @Override
    public ConnectionMeResponse addConnection(ConnectMeSaveDto saveDto) {
        ConnectMe connectMe = new ConnectMe();
        connectMe.setConnectionName(saveDto.getConnectionName());
        connectMe.setLink(saveDto.getLink());
        ConnectMe savedData = this.connectMeRepo.save(connectMe);
        return modelMapper.map(savedData, ConnectionMeResponse.class);
    }

    @Override
    public ConnectionMeResponse updateConnectionById(ConnectMeSaveDto saveDto, int id) {
        ConnectMe connectMe = this.connectMeRepo.findById(id).orElseThrow(() -> new DataNotFoundException("No data found with Id: " + id));
        connectMe.setLink(saveDto.getLink());
        connectMe.setConnectionName(saveDto.getConnectionName());
        ConnectMe updatedData = this.connectMeRepo.save(connectMe);
        return this.modelMapper.map(updatedData, ConnectionMeResponse.class);
    }

    @Override
    public boolean deleteConnectionById(int id) {
        this.connectMeRepo.findById(id).orElseThrow(() -> new DataNotFoundException("No data found with Id: " + id));
        this.connectMeRepo.deleteById(id);
        return true;
    }
}
