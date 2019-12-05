/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd4.agententities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MTimos
 */
public class DBUtil {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SD4_AgentCRUD_PU");
    
    public static EntityManagerFactory getEmf()
    {
        return emf;
    }
    
}
