'use strict';
 
var app = angular.module('pokeApp');

app.controller('loginController', function ($scope, $rootScope, $resource, $location, $cookies, AuthenticationService) {
	    // reset login status
        AuthenticationService.ClearCredentials();
 
        $scope.login = function () {
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.username, $scope.password, $resource, function(response) {
                if(response.success) {
                    AuthenticationService.SetCredentials($scope.username, $scope.password);
                    $scope.invalid = false;
                    $location.path('/');
	            } else {		            	
	                $scope.error = response.message;	                
	                $scope.invalid = true;
	            }
                $scope.dataLoading = false;
            });
                        
        };
        
        $scope.register = function () {
            $scope.dataLoading = true;
            AuthenticationService.Register($scope.username, $scope.password, $resource, $location, function(response) {
                if(response.success) {
                    AuthenticationService.SetCredentials($scope.username, $scope.password);	                    
                    $location.path('/');
	            } else {		            	
	                $scope.error = response.message;
	                $scope.dataLoading = false;
	                $scope.invalid = true;
	            }
            });
                        
        };
});

app.controller('homeController', function ($scope, $rootScope, $location, $cookies, AuthenticationService) {
		$scope.error = '';
		$scope.invalid = false;
		var globals = null;
		if ($cookies.get('loggedUser')) {
			globals = JSON.parse($cookies.get('loggedUser'));
		}
		if (!globals || !globals.logged) {
			$location.path('/login');
		}		
		$scope.logout = function () {
            $scope.dataLoading = true;
            AuthenticationService.ClearCredentials();
            $location.path('/login');
        };
        $scope.managerTeams = function () {
            $scope.dataLoading = true;
            $location.path('/managerTeams');
            $location.replace();
        };
});

app.controller('managerController', ['$scope', '$rootScope', '$location', '$cookies', 'AuthenticationService',
    function ($scope, $rootScope, $location, $cookies, AuthenticationService) {
        $scope.managerTeams = function () {
            $scope.dataLoading = true;
            $location.path('/managerTeams');
            $location.replace();
        };
}]);
