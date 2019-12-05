/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd4.agentcontroller;

import sd4.agententities.Agent;
import static javax.swing.text.StyleConstants.ModelAttribute;
import javax.validation.Valid;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sd4.agentservice.AgentService;

/**
 *
 * @author MTimos
 */
@Controller
public class AuthorsController {
    
    //AgentService service = new AgentService();
    @Autowired
    AgentService service;
    
    @GetMapping("/agents")
    public ModelAndView getAllAgents(){
        return new ModelAndView("/allAgents", "agentList", service.getAllAgents());
        
    }
    
    
    @GetMapping("/add")
    public ModelAndView displayAgentAddForm() {
        return new ModelAndView("/addAgent", "agent", new Agent());
}
    
    //@RequestMapping(value = "/addAgent", method = RequestMethod.POST)
// @PostMapping("/addAgent")
// public ModelAndView addAnAgent(@FormParam("id") int id,
//                                   @FormParam("name") String name,   
//                                   @FormParam("phone") String phone,  
//                                   @FormParam("fax") String fax,  
//                                   @FormParam("email") String email) {
//     
//     Agent agent = new Agent(id, name, fax, phone, email);
//     service.addAnAgent(agent);
//     return new ModelAndView("/displayAgent", "agent", agent);
//	//create the agent object
//	//add the object to the list
//	//route the user to the next page
//        
//}
 
 // @RequestMapping(value = "/addAgent", method = RequestMethod.POST)
    @PostMapping("/addAgent")
    public ModelAndView addAnAgent(@Valid @ModelAttribute("agent")Agent agent, 
     // BindingResult result, ModelMap model)
    BindingResult result){
        if (result.hasErrors()) {
                //display error page
        }
 //       service.addAnAgent(agent);
        return new ModelAndView("/displayAgent", "agent", agent);
        //add the agent object to the list
        //route the user to the next page
    }
 
 //@RequestMapping(value = "/delete", method = RequestMethod.GET)
@GetMapping("/delete")
public ModelAndView deleteAnAgent(@QueryParam("id") int id) {
//    service.deleteAnAgent(id);
    return new ModelAndView(" AllAgents", "agentList", service.getAllAgents());
	//delete the agent
	//route the user to the next page
}
}
