package com.example.userHenrique.service;

import com.example.userHenrique.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> listarTodos() {
        return usuarios;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream().filter(usuario -> usuario.getId().equals(id)).findFirst();
    }

    public Usuario criar(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    public Optional<Usuario> atualizar(Long id, Usuario usuarioAtualizado) {
        return buscarPorId(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            return usuario;
        });
    }

    public boolean deletar(Long id) {
        return usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}
