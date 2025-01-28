package com.portfolio.about_me.Service;

import com.portfolio.about_me.Dto.ConnectMeSaveDto;
import com.portfolio.about_me.Dto.ConnectionMeResponse;

import java.util.List;

public interface ConnectMeService {

    List<ConnectionMeResponse> getAllConnection();
    boolean addConnection(ConnectMeSaveDto saveDto);
    boolean updateConnectionById(ConnectMeSaveDto saveDto, int id);
    boolean deleteConnectionById(int id);
}
