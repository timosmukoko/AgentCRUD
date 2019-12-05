/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd4.agentservice;

import sd4.agententities.DBUtil;
import sd4.agententities.Agents;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author MTimos
 */
@Service
public class AgentService {
    
    public static List<Agents> getAllAgents(){
    
        EntityManager em = DBUtil.getEmf().createEntityManager();
        String q = "SELECT a FROM Agents a";
        TypedQuery<Agents> tq = em.createQuery(q, Agents.class);
        
        List<Agents> list;
         
        try{
            list = tq.getResultList();
            if(list == null || list.isEmpty())
                list = null;
        }
        finally {
            em.close();
        }      
       
        
//        System.out.println("list size " + list.size());
//        for (Agents a : list) {
//            System.out.println(a.getName());
//        }
         return list;
    } 
    
     public static void editAnAgent(Agents a) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(a);
            trans.commit();
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
        finally{
            em.close();
        }  
    }
        
        public static void addAnAgent(Agents a) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(a);           
            trans.commit();
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
        finally{
            em.close();
        }
    }
         
          public static void deleteAgent(Agents a) {
              
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
//        Properties p = em.find(Properties.class, id);
             
        try {
            trans.begin();
            em.remove(em.merge(a));          
            trans.commit();
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
         finally{
            em.close();
        }
    }
          
        public static Agents getAgentByID(int id){
        
        EntityManager em= DBUtil.getEmf().createEntityManager();
        
        try{
            Agents a = em.find(Agents.class, id);
             return a;
        }
        finally{
            em.close();
        }  
    }   
//    static List<Agent> agentList = new ArrayList();
//    
//    static {
//        agentList.add(new Agent(1, "Sue Robert", "999-555-111", "78-45-56-51", "Sue.Roberts@litrealty.com", "sue123"));
//        agentList.add(new Agent(2, "Natasha Watkin", "999-555-112", "78-45-56-52", "Natasha.Watkins@litrealty.com", "natasha123"));
//        agentList.add(new Agent(3, "Chris Clarkson", "999-555-113", "78-45-56-53", "Chris.Clarkson@litrealty.com", "chris123"));
//        agentList.add(new Agent(4, "Laura Blain", "999-555-114", "78-45-56-54", "Laura.Blain@litrealty.com", "laura123"));
//        agentList.add(new Agent(5, "Dave Lindale", "999-555-115", "78-45-56-55", "Dave.Lindale@litrealty.com", "dave123"));   
//    }
//    
//    public List<Agent> getAllAgents() {
//       return agentList;
//    }//end getAllAgents
    
//    public void addAnAgent(Agent a) {
//        agentList.add(a);
//    }//end addAnAgent
//    
//    public void deleteAnAgent(int id) {
//        //System.out.println("auto wired baby!");
//        Iterator<Agent> iterator = agentList.iterator();
//        while (iterator.hasNext()) {
//            Agent agent = iterator.next();
//            if (agent.getId() == id) {
//                iterator.remove();
//            }
//        }
//    }//end deleteAnAgent
    
   
}
