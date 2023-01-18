package com.laurasoto.examenSponja2.servicios;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.laurasoto.examenSponja2.modelos.Usuario;
import com.laurasoto.examenSponja2.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {
	private final UsuarioRepositorio usuarioRepositorio;
	public UsuarioServicio(UsuarioRepositorio usuarioRepositorio){
		this.usuarioRepositorio = usuarioRepositorio;
	}
	//guarda usuario
	public Usuario guardaUsuario(Usuario nuevoUsuario){
		return usuarioRepositorio.save(nuevoUsuario);
	}
	
	// registrar el usuario y hacer Hash a su password
    public Usuario registerUser(Usuario user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return usuarioRepositorio.saveAndFlush(user);
    }

    // encontrar un usuario por su email
    public Usuario findByEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }
    
    // encontrar un usuario por su id
    public Usuario findUserById(Long id) {
    	Optional<Usuario> u = usuarioRepositorio.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
	 // autenticar usuario
	    public boolean authenticateUser(String email, String password) {
	    // primero encontrar el usuario por su email
	    Usuario usuario = usuarioRepositorio.findByEmail(email);
	    // si no lo podemos encontrar por su email, retornamos false
	    if(usuario == null) {
	        return false;
	    } else {
	    	// si el password coincide devolvemos true, sino, devolvemos false
	        if(BCrypt.checkpw(password, usuario.getPassword())) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	    }
	
}
