package com.portfolio.about_me.Imples;

import com.portfolio.about_me.Dto.AboutMeResponse;
import com.portfolio.about_me.Dto.AboutMeSaveDto;
import com.portfolio.about_me.Repository.AboutMeRepo;
import com.portfolio.about_me.Service.AboutMeService;
import com.portfolio.about_me.entity.AboutMe;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AboutMeImplement implements AboutMeService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AboutMeRepo repo;

    @Override
    public AboutMeResponse getAboutMe() {
        List<AboutMe> aboutMe = this.repo.findAll();
        if (aboutMe.isEmpty()) {
            return null;
        } else {
            AboutMeResponse response = this.modelMapper.map(aboutMe.get(0), AboutMeResponse.class);
            response.setTotalProjects(10);
            return response;
        }
    }

    @Override
    public boolean update(AboutMeSaveDto saveDto) {
        List<AboutMe> aboutMe = this.repo.findAll();
        if (aboutMe.isEmpty()) {
            return false;
        } else {
            AboutMe savedData = aboutMe.get(0);
            savedData.setName(saveDto.getName());
            savedData.setTechStack(saveDto.getTechStack());
            savedData.setDescription(saveDto.getDescription());
            savedData.setDateOfBirth(saveDto.getDateOfBirth());
            savedData.setCurrentAddress(saveDto.getCurrentAddress());
            savedData.setPermanentAddress(saveDto.getPermanentAddress());
            this.repo.save(savedData);
            return true;
        }
    }
}
