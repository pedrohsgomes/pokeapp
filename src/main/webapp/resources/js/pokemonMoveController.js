'use strict';
 
var app = angular.module('pokeApp');

app.service('PokemonMovesService', function ($log, $resource) {   
    return {
        getAll: function () {
            var pokemonMovesResource = $resource('moves', {}, {
                query: {method: 'GET', params: {}, isArray: true}
            });
            return pokemonMovesResource.query();
        },
        getPokemon: function (userName, teamName, pokemonName) {
            var pokemonMovesResource = $resource('getPokemonByTeam', {}, {
                query: {method: 'GET', params: {userName: userName, teamName : teamName, pokemonName : pokemonName}, isArray: false}
            });
            return pokemonMovesResource.query();
        },
        addMove: function (userName, teamName, pokemonName, name) {
            var pokemonMovesResource = $resource('addMove', {}, {
                query: {method: 'GET', 
                	params: {userName: userName, teamName : teamName, pokemonName : pokemonName, moveName: name}, 
                	isArray: true}
            });
            return pokemonMovesResource.query();
        },
        removeMove: function (userName, teamName, pokemonName, name) {
            var pokemonMovesResource = $resource('removeMove', {}, {
                query: {method: 'GET', 
                	params: {userName: userName, teamName : teamName, pokemonName : pokemonName, moveName: name}, 
                	isArray: true}
            });
            return pokemonMovesResource.query();
        }
    }
});

app.controller('pokemonMovesController', function ($scope, $log, $location, $routeParams, $cookies, PokemonMovesService) {
	
	var globals = null;
    if ($cookies.get('loggedUser')) {
		globals = JSON.parse($cookies.get('loggedUser'));
	} else {
		$location.path('/');
		return;
	}
    
    $scope.add = add;
    $scope.remove = remove;
	
	$scope.pokemonParam = PokemonMovesService.getPokemon(globals.currentUser.userName, $routeParams.teamName, $routeParams.pokemonName);
	$scope.teamName = $routeParams.teamName;
	$scope.dataLoading = true;
	$scope.moves = PokemonMovesService.getAll();
	
	function addMove(name){
		$scope.pokemonParam.moves = PokemonMovesService.addMove(globals.currentUser.userName, $scope.teamName, $scope.pokemonParam.name, name);
    }
	
	function removeMove(name){
		$scope.pokemonParam.moves = PokemonMovesService.removeMove(globals.currentUser.userName, $scope.teamName, $scope.pokemonParam.name, name);
    }
	
	function add(moveName){
        console.log('move to be added', moveName);
        addMove(moveName);
    }
	
	function remove(moveName){
        console.log('move to be deleted', moveName);
        removeMove(moveName);
    }
});