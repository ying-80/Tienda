package tienda.Tienda.service.Impl;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.Tienda.dao.UsuarioDao;
import tienda.Tienda.domain.Rol;
import tienda.Tienda.domain.Usuario;
import tienda.Tienda.service.UsuarioDetailsService;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Buscar el usuario que pasamos por parametro
        Usuario usuario=usuarioDao.findByUsername(username);
        
        //se valida si se encontro el usuario o no
        if (usuario==null){
        throw new UsernameNotFoundException(username);
        
        }
        //si hay usurio
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        //vamos a recuperar los roles del usuario y se crean los roles de seguridad de sprint
        var roles=new ArrayList<GrantedAuthority>();
                
        for (Rol rol:usuario.getRoles()){
        roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        //se retorna un User de tipo UserDetails
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
        
    }

}
