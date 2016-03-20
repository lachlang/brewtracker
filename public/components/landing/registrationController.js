/*
 * Controller search for connection, uploading bulk connections and for sending connection/invitation requests
 */
brewTrackerApp.controller('RegistrationCtrl', ['$scope', '$log', 'Registration', function($scope, $log, Registration) {

	var ctrl = this;

	ctrl.register = function() {
		alert(ctrl.firstName);
	};
}]);