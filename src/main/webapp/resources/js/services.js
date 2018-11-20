'use strict';
 
var services = angular.module('pokeApp');

services.factory('AuthenticationService', function (Base64, $http, $rootScope, $resource, $cookies) {
        var service = {};

        service.Login = function (userName, password, $resource, callback) {        	
        	var user = {
                    userName: userName,
                    password: password
                };
        	
        	var userResource = $resource('login', {}, {
                save: {method: 'POST', params: {userName: userName,
                    password: password}, isArray: false}
            });
        	var result = userResource.save();
        	result.$promise
        		.then(function(response) {
        			$rootScope.status = response.status;
        			$rootScope.data = response.data;
        			response.success = true;
	                callback(response);
        		},
        		function(response) {
        			$rootScope.data = response.data || 'Request failed';
        			$rootScope.status = response.status;
	                response.message = 'Can not login, userName or password may be wrong!';
	                response.success = false;
	                callback(response);
        		});

        };
        
        service.Register = function (userName, password, $resource, $location, callback) {

        	var user = {
                userName: userName,
                password: password
            };
        	
        	//var url = $location.protocol() + "://" + $location.host() + ":" + $location.port() + "registerUser";
        	
        	var userResource = $resource('registerUser', {}, {
                save: {method: 'POST', params: {userName: userName,
                    password: password}, isArray: false}
            });
        	var result = userResource.save();
        	result.$promise
        		.then(function(response) {
        			$rootScope.status = response.status;
        			$rootScope.data = response.data;
        			response.success = true;
	                callback(response);
        		},
        		function(response) {
        			$rootScope.data = response.data || 'Request failed';
        			$rootScope.status = response.status;
	                response.message = 'Can not create a user, maybe already exists!';
	                response.success = false;
	                callback(response);
        		});       
        };
 
        service.SetCredentials = function (userName, password) {
            var authData = Base64.encode(userName + ':' + password);
 
            $rootScope.globals = {
                currentUser: {
                    userName: userName,
                    authData: authData
                },
            	logged: true
            };

            sessionStorage.setItem('loggedUser', JSON.stringify($rootScope.globals));
            $cookies.putObject('loggedUser', ($rootScope.globals));            
            $http.defaults.headers.common['Authorization'] = 'Basic ' + authData;
        };
 
        service.ClearCredentials = function () {
            $rootScope.globals = {};
            $cookies.remove('loggedUser');
            sessionStorage.removeItem('loggedUser');
            $http.defaults.headers.common.Authorization = 'Basic ';
        };
 
        return service;
    })
 
.factory('Base64', function () {
    /* jshint ignore:start */
 
    var keyStr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';
 
    return {
        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;
 
            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);
 
                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;
 
                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }
 
                output = output +
                    keyStr.charAt(enc1) +
                    keyStr.charAt(enc2) +
                    keyStr.charAt(enc3) +
                    keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);
 
            return output;
        },
 
        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;
 
            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                window.alert("There were invalid base64 characters in the input text.\n" +
                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                    "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
 
            do {
                enc1 = keyStr.indexOf(input.charAt(i++));
                enc2 = keyStr.indexOf(input.charAt(i++));
                enc3 = keyStr.indexOf(input.charAt(i++));
                enc4 = keyStr.indexOf(input.charAt(i++));
 
                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;
 
                output = output + String.fromCharCode(chr1);
 
                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }
 
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
 
            } while (i < input.length);
 
            return output;
        }
    };
 
    /* jshint ignore:end */
});