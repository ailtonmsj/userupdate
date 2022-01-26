package br.com.ailtonmsj.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.ailtonmsj.dto.Usuario;
import br.com.ailtonmsj.service.UsuarioService;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private UsuarioService usuarioService;

    @PUT
    @Path("/{nome}/{status}")
    public Usuario update(@PathParam("nome")String nome, @PathParam("status") Boolean status) {
    	
    	log.info("atualizando usuário" + nome);
    	
    	Usuario usuario = usuarioService.get(nome);
    	if(usuario == null || usuario.getNome() == null)
    		return null;
    				
    	usuario.setStatus(status);
    	
    	return usuarioService.add(usuario);
    }
}
