package com.babor.spring.web.services;

import com.babor.spring.web.dao.Notice;
import com.babor.spring.web.dao.NoticesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.security.Principal;
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

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public void createNotice(Notice notice) {
        noticesDAO.createNotice(notice);
    }

    public void throwTestException() {
        noticesDAO.getNoticeById(999999);
    }

    public boolean hasNotices(String username) {
        if (username == null) return false;

        List<Notice> notices = noticesDAO.getNoticeByUsername(username);

        if (notices.size() == 0) return false;

        return true;
    }

    public List<Notice> getCurrentUserNotices(String username) {
        return noticesDAO.getNoticeByUsername(username);
    }

    public Notice getNoticeById(Integer id) {
        return noticesDAO.getNoticeById(id);
    }

    public void createOrUpdateNotice(Notice notice, Principal principal) {
        if (notice.getId() != 0) {
            Notice n = noticesDAO.getNoticeById(notice.getId());

            if (! n.getUsername().equals(principal.getName())) {
                throw new AccessDeniedException("Your have not permission to delete resources");
            }
            noticesDAO.updateNotice(notice);
        }
        else {
            noticesDAO.createNotice(notice);
        }
    }
}
