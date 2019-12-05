/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd4.agentcontroller;


import sd4.agententities.Agents;
import sd4.agententities.DBUtil;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import sd4.agentservice.AgentService;


/**
 *
 * @author MTimos
 */
@Controller
@RequestMapping("/agent")
@SessionAttributes("agent")
public class AgentController {  
    
    @Autowired
    AgentService service;
    
    @GetMapping("")
    public ModelAndView getAgents(){
        
       FormatStyle style = FormatStyle.SHORT;
       DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(style);
       DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedDate(style);
       
       //get the date
       LocalDate date = LocalDate.now();     
       ZonedDateTime time = ZonedDateTime.now();   
       System.out.println(dateFormatter.format(date) + "\t" + timeFormatter.format(time));
       return new ModelAndView("/allAgents", "agentList", service.getAllAgents());
    }
    
    
    @GetMapping("/delete")
    public ModelAndView deleteAnAgent(@QueryParam("id") Agents id) {
    service.deleteAgent(id);
    return new ModelAndView("/AllAgents", "agentList", service.getAllAgents());
	//delete the agent
	//route the user to the next page
    }
//    
    @GetMapping("/add")
    public ModelAndView displayAgentAddForm(ModelAndView model) {
    return new ModelAndView("/addAgent", "agent", new Agents());
//         model.setViewName("/addAgent");
//         return model;
    }
    
    @PostMapping("/addAgent")
    public ModelAndView addAnAgent(ModelMap model, @Valid @ModelAttribute("agent") Agents agent, BindingResult result){ 
     // BindingResult result, ModelMap model)
    
        if (result.hasErrors()) {
            return new ModelAndView("/addAgent");
                //display error page
        }
        
        service.addAnAgent(agent);
      // return new ModelAndView("/displayAgent", "agent", agent);
        return new ModelAndView("forward:/agent");
      //return new ModelAndView("redirect:/agent", "agentList", service.getAllAgents());
      //return new ModelAndView("/allAgents", "agentList", service.getAllAgents());
      //add the agent object to the list
      //route the user to the next page
        
    }
    
    @GetMapping("/find/{agentId}")
    public ModelAndView getAnAgent(@PathVariable("agentId") int agentId, ModelAndView model){
     // model.addOject("agent", service.findOne(agentId));
      model.setViewName("/displayAgenty");
      return model;
   }
    
    @GetMapping("/edit")
    public ModelAndView displayAgentEditForm(@QueryParam("id") int id, ModelAndView model) {
       
      //System.out.println("id " + id);
       Agents a = service.getAgentByID(id);
     //return new ModelAndView("/editAgent");
       model.setViewName("/editAgent");
       model.addObject("agent", a);
       return model;
    }
    
    @PostMapping("/editAgent")
    public ModelAndView editAnAgent(@Valid @ModelAttribute("agent") Agents agent,
            BindingResult result, SessionStatus status){
        if (result.hasErrors()){
            return new ModelAndView("/error");
        }
        service.editAnAgent(agent);
        status.setComplete();
        return new ModelAndView("redirect:/agent");
    }   
}
