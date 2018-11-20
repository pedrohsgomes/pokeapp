var appPoke = angular
    .module('pokeManagerApp', ['ngResource', 'ngRoute', 'ngCookies'])
    .service('PokemonsService', function ($log, $resource) {
        return {
            getAll: function () {
                var pokemonsResource = $resource('pokemons', {}, {
                    query: {method: 'GET', params: {}, isArray: true}
                });
                return pokemonsResource.query();
            }
        }
    })    
    .controller('pokemonsController', function ($scope, $log, PokemonsService) {
        $scope.pokemons = PokemonsService.getAll();
    })
    .service('TeamsService', function ($log, $resource) {
        return {
            getAll: function () {
                var pokemonsResource = $resource('pokemons', {}, {
                    query: {method: 'GET', params: {}, isArray: true}
                });
                return pokemonsResource.query();
            }
        }
    }) 
    .controller('teamsController', function ($scope, $log, PokemonsService) {
    	$scope.teams = PokemonsService.getAll();
    });
