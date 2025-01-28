package com.portfolio.about_me.Service;
import com.portfolio.about_me.Dto.AboutMeResponse;
import com.portfolio.about_me.Dto.AboutMeSaveDto;

public interface AboutMeService {

    AboutMeResponse getAboutMe();

    boolean update(AboutMeSaveDto saveDto);
}
