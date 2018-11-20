'use strict';

var app = angular.module('pokeApp');

app.controller('formCtrl', function($scope) {
    $scope.master = {firstName:"John", lastName:"Doe"};
    $scope.reset = function() {
        $scope.user = angular.copy($scope.master);
    };
    $scope.reset();
});

app.controller('teamController', function($scope, $cookies, $location, teamService) {
//    $scope.team={name:"", user: { userName:null } };
	$scope.team={};
    $scope.teams=[];

    $scope.submit = submit;
    $scope.edit = edit;
    $scope.remove = remove;
    $scope.reset = reset;
    $scope.addPokemons = addPokemons;
    $scope.fetchAllTeams = fetchAllTeams;
    
    var globals = null;
    if ($cookies.get('loggedUser')) {
		globals = JSON.parse($cookies.get('loggedUser'));
	} else {
		$location.path('/');
		return;
	}
    
    fetchAllTeams();

    function fetchAllTeams(){
        teamService.fetchAllTeams()
            .then(
            function(d) {
                $scope.teams = d;
            },
            function(errResponse){
                console.error('Error while fetching Teams');
            }
        );
    }

    function createTeam(team){
        teamService.createTeam(team)
            .then(
            function(){
            	fetchAllTeams();
            },
            function(errResponse){
                console.error('Error while creating Team');
            }
        );
    }

    function updateTeam(team){
        teamService.updateTeam(team, team.user.userName)
            .then(
    		function(){
            	fetchAllTeams();
            },
            function(errResponse){
                console.error('Error while updating Team');
            }
        );
    }

    function deleteTeam(name){
        teamService.deleteTeam(name)
            .then(
    		function(){
            	fetchAllTeams();
            },
            function(errResponse){
                console.error('Error while deleting Team');
            }
        );
    }

    function submit() {
        if(!$scope.team.user || $scope.team.user.userName===null){
            console.log('Saving New Team', $scope.team);
            createTeam($scope.team);
        }else{
            updateTeam($scope.team);
            console.log('Team updated with name', $scope.team.name);
        }
        reset();
    }

    function edit(name){
        console.log('name to be edited', name);
        for(var i = 0; i < $scope.teams.length; i++){
            if($scope.teams[i].name === name) {
                $scope.team = angular.copy($scope.teams[i]);
                $scope.team.oldName = $scope.team.name;
                break;
            }
        }
    }

    function remove(teamName){
        console.log('name to be deleted', teamName);
        if($scope.team.name === teamName) {//clean form if the Team to be deleted is shown there.
            reset();
        }
        deleteTeam(teamName);
    }
    
    function addPokemons(teamName){
        console.log('pokemons to add in team', teamName);
        $location.path('/managerPokemonsTeam/'+teamName.name);
        $location.replace();
    }

    function reset(){
    	$scope.team={name:'', user: {userName:null}};
        $scope.teamForm.$setPristine(); //reset Form
    }

});
