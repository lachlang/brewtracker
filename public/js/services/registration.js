btServices.service('Registration', ['$http', '$log', function($http, $log){
    return {

		register: function(firstName, lastName, emailAddress, password) {
			return $http({
				method: 'POST',
				url: '/api/register',
				data: {
    				"apiVersion" : "1.0",
    				"data" : {
    					"firstName": firstName,
    					"lastName": lastName,
    					"emailAddress": emailAddress,
    					"password": password
    				}
				}
			});
		}

	}
}]);