'use strict';

var services = angular.module('pokeApp');

services.factory('teamService', function($http, $q, $resource, $cookies, $location){

    var REST_SERVICE_URI = 'http://localhost:8080/pokeapp/team/';    

//    var factory = {};
    
    var globals = null;
    if ($cookies.get('loggedUser')) {
		globals = JSON.parse($cookies.get('loggedUser'));
	} else {
		$location.path('/');
		return;
	}

    return { 
    	fetchAllTeams: function() {
	        var deferred = $q.defer();
	        if (globals == null) {
	        	return;
	        }
	        $http.get(REST_SERVICE_URI+'listAllTeams', {params: {userName: globals.currentUser.userName}})
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while fetching Teams');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
    	},
        createTeam: function(team) {
	        var deferred = $q.defer();
	        if (globals == null) {
	        	return;
	        }
	        var userResource = $resource('team/createTeam', {}, {
	            save: {method: 'POST', params: {userName: globals.currentUser.userName, name: team.name}, isArray: false}
	        });
	        var result = userResource.save();
	    	result.$promise
		    	.then(function(response) {
		    		deferred.resolve(response.data);
				},
				function(response) {
					console.error('Error while creating Teams');
		            deferred.reject(errResponse);
				});
	        return deferred.promise;
	    },
	    updateTeam: function(team) {
	        var deferred = $q.defer();
	        var userResource = $resource('team/updateTeam', {}, {
	            save: {method: 'POST', params: {userName: team.user.userName, oldName: team.oldName, newName: team.name }, isArray: false}
	        });
	        var result = userResource.save();
	    	result.$promise
		    	.then(function(response) {
		    		deferred.resolve(response.data);
				},
				function(response) {
					console.error('Error while creating Teams');
		            deferred.reject(errResponse);
				});
	        return deferred.promise;
	    },
	    deleteTeam: function(teamName) {
	        var deferred = $q.defer();
	        if (globals == null) {
	        	return;
	        }
	        $http.delete(REST_SERVICE_URI+globals.currentUser.userName+"/"+teamName)
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while deleting Team');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
    };
});
