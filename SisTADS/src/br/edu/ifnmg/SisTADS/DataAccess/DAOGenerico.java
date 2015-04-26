/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SisTADS.DataAccess;


import br.edu.ifnmg.SisTADS.DomainModel.Repositorios.Repositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
public abstract class DAOGenerico<T> implements Repositorio<T> {

    private EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SisTADSPU");
    protected EntityManager manager;
    private Class tipo;
    String where = "";
    String orderby = "";
    String jpql = "select c from ";
    Map<String,Object> parametros = new HashMap<>();

    public DAOGenerico(Class t) {
        manager = fabrica.createEntityManager();
        this.tipo = t;
        jpql += t.getSimpleName() + " c";
    }
    
    public DAOGenerico<T> OrderBy(String campo, String order){
        
        if(campo != null){
            if(orderby.length() > 0)
                    orderby += ",";
        
            orderby += "c." + campo + " " + order;
        }
        
        return this;
    }
    
    public DAOGenerico<T> IgualA(String campo, Object valor){
        
        if(where.length() > 0)
                    where += " and ";
        
        if(valor != null){
                where = where + "c." + campo + " = :" + campo;
                parametros.put(campo, valor);
            }
        
        return this;
    }
    
    public DAOGenerico<T> Like(String campo, String valor){
        
        if(where.length() > 0)
                    where += " and ";
        
        if(valor != null){
                where = where + "c." + campo +" like '%"+ valor +"%'";
            }
        
        return this;
    }
    
    public List<T> Buscar() {
        if(where.length() > 0){
            jpql = jpql + " where " + where;
        }
        
        if(orderby.length() > 0)
            jpql = jpql + " order by " + orderby;
        
        Query consulta = manager.createQuery(jpql);
        
        for(String parametro : parametros.keySet())
            consulta.setParameter(parametro, parametros.get(parametro));
        
        where = "";
        
        return consulta.getResultList();
    }

    @Override
    public boolean Salvar(T obj) {
        EntityTransaction t = manager.getTransaction();
        try {
            t.begin();
            manager.persist(obj);
            t.commit();
            return true;
        } catch(Exception e){
            t.rollback();
            return false;
        }
    }

    @Override
    public T Abrir(Long id) {
        return (T)manager.find(tipo, id);
    }

    @Override
    public boolean Apagar(T obj) {
        EntityTransaction t = manager.getTransaction();
        try {
            t.begin();
            manager.remove(obj);
            t.commit();
            return true;
        } catch(Exception e){
            t.rollback();
            return false;
        }
    }

    public abstract List<T> Buscar(T filtro);

}
