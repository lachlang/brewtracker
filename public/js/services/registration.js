btServices.service('Registration', ['$http', '$log', function($http, $log){
    return {

		register: function(firstName, lastName, emailAddress, password) {
			return $http({
				method: 'PUT',
				url: '/api/registration',
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