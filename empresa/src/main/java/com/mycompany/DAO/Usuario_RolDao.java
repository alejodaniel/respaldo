/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.dominio.Usuario;
import com.mycompany.dominio.Usuario_Rol;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Iepiadm
 */
public class Usuario_RolDao extends DAOAbstract<Usuario_Rol> {

    public Usuario_RolDao(Usuario_Rol usuario_Rol) {
        super(usuario_Rol);
    }

    @Override
    public List<Usuario_Rol> buscarTodos() {
        Query query = this.getEntityManager().createQuery("Select ur from Usuario_Rol ur");
        return query.getResultList();
    }

    public int nextId() {
//        Query query = this.getEntityManager().createQuery("Select MAX(ur.usrol_id) from Usuario_Rol ur");
        Query query = this.getEntityManager().createQuery("Select u from Usuario_Rol u where u.usrol_id = (Select MAX(ur.usrol_id) from Usuario_Rol ur)");
        Usuario_Rol usuario_Rol = (Usuario_Rol) query.getSingleResult();
        if (usuario_Rol == null) {
            return 1;
        } else {
            int valor = usuario_Rol.getUsrol_id();
            return valor + 1;
        }
    }

    public Usuario_Rol getUsuario_Rol(int idUsuario, int idRol) {
//        System.out.println("589+859589598");
        try {
            Query query = this.getEntityManager().createQuery("Select u from Usuario_Rol u where u.usrol_idRol =  " + idRol + " and u.usrol_idUsuario= " + idUsuario);
            return (Usuario_Rol) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }

    public boolean getUsuario_RolLogin(int idUsuario, int idRol) {
//        System.out.println("589+859589598");
        try {
            Query query = this.getEntityManager().createQuery("Select u from Usuario_Rol u where u.usrol_idRol =  " + idRol + " and u.usrol_idUsuario= " + idUsuario);
            Usuario_Rol usuario_Rol = (Usuario_Rol) query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }

    }

//    public Usuario pertencece() {
//        Query query = this.getEntityManager().createQuery("Select u from Usuario_Rol u where u.usrol_idUsuario = p.usu_id");
//        return (Usuario) query.getSingleResult();
//
//    }
}
