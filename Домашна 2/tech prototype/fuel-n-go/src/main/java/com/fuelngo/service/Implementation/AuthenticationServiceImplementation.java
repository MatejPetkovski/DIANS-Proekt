package com.fuelngo.service.Implementation;

import com.fuelngo.model.User;
import com.fuelngo.model.exceptions.InvalidArgumentsException;
import com.fuelngo.model.exceptions.InvalidCredentialsException;
import com.fuelngo.model.exceptions.PasswordsNotMatchingException;
import com.fuelngo.model.exceptions.UserAlreadyExistsException;
import com.fuelngo.repository.UserRepository;
import com.fuelngo.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User register(String email_address, String username, String password, String repeatPassword) {
        if(email_address==null || email_address.isEmpty() || username==null || username.isEmpty() || password==null || password.isEmpty() || repeatPassword==null || repeatPassword.isEmpty())
        {
            throw new InvalidArgumentsException();
        }
        User user=null;
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UserAlreadyExistsException(username);

        if(!password.equals(repeatPassword))
            throw new PasswordsNotMatchingException();

        user=new User(email_address,username,password);
        return this.userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {

        if(username==null || username.isEmpty() || password==null || password.isEmpty())
        {
            throw new InvalidArgumentsException();
        }
        return this.userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidCredentialsException::new);
    }
}
