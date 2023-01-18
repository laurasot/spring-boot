package com.laurasoto.authentication.servicios;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.laurasoto.authentication.modelos.User;
import com.laurasoto.authentication.repositorio.UserRepositorio;

@Service
public class UserServicio {
	 private final UserRepositorio userRepositorio;
	    
	    public UserServicio(UserRepositorio userRepositorio) {
	        this.userRepositorio = userRepositorio;
	    }
	    
	    // registrar el usuario y hacer Hash a su password
	    public User registerUser(User user) {
	        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	        user.setPassword(hashed);
	        return userRepositorio.save(user);
	    }

	    // encontrar un usuario por su email
	    public User findByEmail(String email) {
	        return userRepositorio.findByEmail(email);
	    }
	    
	    // encontrar un usuario por su id
	    public User findUserById(Long id) {
	    	Optional<User> u = userRepositorio.findById(id);
	    	
	    	if(u.isPresent()) {
	            return u.get();
	    	} else {
	    	    return null;
	    	}
	    }

	    // autenticar usuario
	    public boolean authenticateUser(String email, String password) {
        // primero encontrar el usuario por su email
        User user = userRepositorio.findByEmail(email);
        // si no lo podemos encontrar por su email, retornamos false
        if(user == null) {
            return false;
        } else {
        	// si el password coincide devolvemos true, sino, devolvemos false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
