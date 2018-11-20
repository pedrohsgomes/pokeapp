'use strict';
 
var app = angular.module('pokeApp');

app.service('PokemonsService', function ($log, $resource) {   
    return {
        getAll: function () {
            var pokemonsResource = $resource('pokemons', {}, {
                query: {method: 'GET', params: {}, isArray: true}
            });
            return pokemonsResource.query();
        },
        getTeam: function (userName, teamName) {
            var pokemonsResource = $resource('team/'+userName+'/'+teamName, {}, {
                query: {method: 'GET', params: {}, isArray: false}
            });
            return pokemonsResource.query();
        },
        addPokemon: function (userName, teamName, name) {
            var pokemonsResource = $resource('addPokemon', {}, {
                query: {method: 'GET', 
                	params: {userName: userName, teamName : teamName, pokemonName : name}, 
                	isArray: true}
            });
            return pokemonsResource.query();
        },
        removePokemon: function (userName, teamName, name) {
            var pokemonsResource = $resource('removePokemon', {}, {
                query: {method: 'GET', 
                	params: {userName: userName, teamName : teamName, pokemonName : name}, 
                	isArray: true}
            });
            return pokemonsResource.query();
        }
    }
});

app.controller('pokemonsController', function ($scope, $log, $location, $routeParams, $cookies, PokemonsService) {
	
	var globals = null;
    if ($cookies.get('loggedUser')) {
		globals = JSON.parse($cookies.get('loggedUser'));
	} else {
		$location.path('/');
		return;
	}
    
    $scope.add = add;
    $scope.remove = remove;
    $scope.addMoves = addMoves;
	
	$scope.teamParam = PokemonsService.getTeam(globals.currentUser.userName, $routeParams.teamName);
	$scope.dataLoading = true;
	$scope.pokemons = PokemonsService.getAll();
	
	function addPokemon(name){
		$scope.teamParam.pokemons = PokemonsService.addPokemon(globals.currentUser.userName, $scope.teamParam.name, name);
    }
	
	function removePokemon(name){
		$scope.teamParam.pokemons = PokemonsService.removePokemon(globals.currentUser.userName, $scope.teamParam.name, name);
    }
	
	function add(pokemonName){
        console.log('pokemon to be added', pokemonName);
        addPokemon(pokemonName);
    }
	
	function remove(pokemonName){
        console.log('pokemon to be deleted', pokemonName);
        removePokemon(pokemonName);
    }
	
	function addMoves(pokemonName){
        console.log('moves to add in pokemon', pokemonName);
        $location.path('/managerPokemonMoves/'+$scope.teamParam.name+'/'+pokemonName);
        $location.replace();
    }
});