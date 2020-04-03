package com.babor.spring.web.services;

import com.babor.spring.web.dao.Notice;
import com.babor.spring.web.dao.NoticesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticesService")
public class NoticesService {
    private NoticesDAO noticesDAO;

    @Autowired
    public void setNoticesDAO(NoticesDAO noticesDAO) {
        this.noticesDAO = noticesDAO;
    }

    public List<Notice> getCurrent() {
        return noticesDAO.getNotices();
    }
}
