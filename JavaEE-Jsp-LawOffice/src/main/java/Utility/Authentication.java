package Utility;

import Model.User;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class Authentication {

    private EntityManagerFactory emf;
    private EntityManager manager;
    private Transaction tr;

    public Authentication(){
        emf = Persistence.createEntityManagerFactory("user");
        manager = emf.createEntityManager();

    }

    public String authenticate(String username,String password){
         if(username.equals("") || password.equals("")
         || username ==null || password ==null){
             return "Inputs cannot be blank!";
         }

         User user;

         try{
             user = getUser(username);
         }catch (NoResultException e){
             return "Username not found";
         }

         if (!(user.getPassword().equals(password))){
             return "Wrong Password";
         }
         return "Success";


    }

    public User getUser(String username){
        return manager.createQuery(
                "SELECT u from User u WHERE u.username =:username", User.class)
                .setParameter("username",username).getSingleResult();

    }


}
