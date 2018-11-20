'use strict';

angular.module('pokeApp', ['ngResource', 'ngRoute', 'ngCookies'])
.config(function($routeProvider, $locationProvider) {
	
	var $cookies;
	angular.injector(['ngCookies']).invoke(['$cookies', function(_$cookies_) {
		$cookies = _$cookies_;
	}]);
	
	$locationProvider.html5Mode(false);
	
	if ($cookies.get('loggedUser')) {
		$cookies.remove('loggedUser');
	}
	
	$routeProvider.when('/', {
		controller : 'homeController',
		templateUrl : 'views/home.jsp'
	}).when('/login', {
		controller : 'loginController',
		templateUrl : 'views/login.jsp',
		hideMenus : true
	}).when('/register', {
		controller : 'loginController',
		templateUrl : 'views/login.jsp',
		hideMenus : true
	}).when('/managerTeams', {
		controller : 'teamController',
		templateUrl : 'views/teams.jsp'
	}).when('/managerPokemonsTeam/:teamName', {
		controller : 'pokemonsController',
		templateUrl : 'views/teamPokemons.jsp'	,
		resolve: {
			teamName: function ($route) {
                return $route.current.params.teamName;
            }
        }
	}).when('/managerPokemonMoves/:teamName/:pokemonName', {
		controller : 'pokemonMovesController',
		templateUrl : 'views/pokemonMoves.jsp'	,
		resolve: {
			teamName: function ($route) {
                return $route.current.params.teamName;
            }
        }
	}).otherwise({
		redirectTo : '/login'
	});
});