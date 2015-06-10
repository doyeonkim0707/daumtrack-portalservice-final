package kr.ac.jeju.service;

import kr.ac.jeju.model.AuthInfo;

public interface AuthService {

    AuthInfo authenticate(String email, String password);
}
