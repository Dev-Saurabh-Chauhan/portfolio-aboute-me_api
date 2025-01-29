package com.portfolio.about_me.Service;

import com.portfolio.about_me.Dto.ConnectMeSaveDto;
import com.portfolio.about_me.Dto.ConnectionMeResponse;

import java.util.List;

public interface ConnectMeService {

    List<ConnectionMeResponse> getAllConnection();
    ConnectionMeResponse addConnection(ConnectMeSaveDto saveDto);
    ConnectionMeResponse updateConnectionById(ConnectMeSaveDto saveDto, int id);
    boolean deleteConnectionById(int id);
}
