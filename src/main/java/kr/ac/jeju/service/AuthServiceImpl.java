package kr.ac.jeju.service;

import kr.ac.jeju.Exception.IdPasswordNotMatchingException;
import kr.ac.jeju.model.AuthInfo;
import kr.ac.jeju.model.User;
import kr.ac.jeju.repository.UserDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserDaoMapper userDaoMapper;

    @Override
    public AuthInfo authenticate(String id, String password) {

        User user = userDaoMapper.findById(id);

        if(user == null){
            throw new IdPasswordNotMatchingException();
        }
        if(!user.matchPassword(password)){
            throw new IdPasswordNotMatchingException();
        }
        return new AuthInfo(user.getId(), user.getName(), user.getAuthority());
    }
}
