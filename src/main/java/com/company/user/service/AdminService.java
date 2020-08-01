package com.company.user.service;

public interface AdminService {
    void blockUser(String login);

    void unblockUser(String login);
}
