package br.com.pokeapimanager.app.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokeapimanager.app.entity.Team;
import br.com.pokeapimanager.app.entity.User;
import br.com.pokeapimanager.app.sevice.TeamService;
 
@RestController
public class TeamController {
 
    @Autowired
    TeamService teamService;
 
    @RequestMapping(value = "/team/listAllTeams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Team>> listAllTeams(@RequestParam("userName") String userName) {
        List<Team> teams = teamService.findAllTeams(new User(userName, ""));
        if(teams.isEmpty()){
            return new ResponseEntity<List<Team>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
    } 
    
    //-------------------Retrieve Single Team--------------------------------------------------------     
    @RequestMapping(value = "/team/{userName}/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Team> getTeam(@PathVariable("userName") String userName, @PathVariable("name") String name) {
        System.out.println("Fetching Team with name " + name);
        Team team = teamService.findTeam(new User(userName, ""), name);
        if (team == null) {
            System.out.println("Team with name " + name + " not found");
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Team>(team, HttpStatus.OK);
    }     
     
    //-------------------Create a Team--------------------------------------------------------     
    @RequestMapping(value = "/team/createTeam", method = RequestMethod.POST)
    public ResponseEntity<Void> createTeam(String userName, String name) {
        System.out.println("Creating Team " + name);
 
        if (teamService.isTeamExist(userName, name)) {
            System.out.println("A Team with name " + name + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        teamService.createTeam(new User(userName,  ""), name);
 
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Team --------------------------------------------------------     
    @RequestMapping(value = "/team/updateTeam", method = RequestMethod.POST)
    public ResponseEntity<Team> updateTeam(String userName, String oldName, String newName) {
        System.out.println("Updating Team " + oldName + " to " + newName);
        User user = new User(userName, "");
        Team currentTeam = teamService.findTeam(user, oldName);
         
        if (currentTeam==null) {
            System.out.println("Team with name " + oldName + " not found");
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
 
        currentTeam.setName(newName);
         
        teamService.updateTeam(user, oldName, currentTeam);
        return new ResponseEntity<Team>(currentTeam, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Team --------------------------------------------------------     
    @RequestMapping(value = "/team/{userName}/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Team> deleteTeam(@PathVariable("userName") String userName, @PathVariable("name") String name) {
        System.out.println("Fetching & Deleting Team with name " + name); 
        User user = new User(userName, "");
		Team team = teamService.findTeam(user , name);
        if (team == null) {
            System.out.println("Unable to delete. Team with name " + name + " not found");
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
 
        teamService.deleteTeam(user, name);
        return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Teams --------------------------------------------------------    
    @RequestMapping(value = "/team/", method = RequestMethod.DELETE)
    public ResponseEntity<Team> deleteAllTeams(@PathVariable("userName") String userName) {
        System.out.println("Deleting All Teams");
 
        teamService.deleteAllTeams(userName);
        return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
    }
 
}