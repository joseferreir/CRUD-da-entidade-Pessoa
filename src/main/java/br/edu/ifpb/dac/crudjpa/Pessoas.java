/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.crudjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author jose2
 */
public class Pessoas {

    private final EntityManager em;

    public Pessoas() {
        this.em = Persistence.
                createEntityManagerFactory("crudJPA_PU").
                createEntityManager();
    }

    public void atualizarEntidade(Pessoa pessoa) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(pessoa);
        t.commit();

    }

    public Pessoa buscarEntidade(int id) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        Pessoa p = em.find(Pessoa.class, id);
        t.commit();
        return p;
    }

    public void excluirEntidade(Pessoa pessoa) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(pessoa);
        t.commit();
    }

    public void novaEntidade(Pessoa pessoa) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(pessoa);
        t.commit();

    }

     public List<Pessoa> listarTodos() {
        Query q = em.createQuery("SELECT p FROM Pessoa p");
        return q.getResultList();
    }
    public void fecharEntityManager() {
        em.close();
    }
}
