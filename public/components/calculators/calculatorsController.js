/*
 * Controller search for connection, uploading bulk connections and for sending connection/invitation requests
 */
brewTrackerApp.controller('CalculatorsCtrl', ['$scope', '$log', function($scope, $log) {

	var ctrl = this;

	ctrl.testy = function() {

	};

	$scope.Lovibond = function(){ return ($scope.SRM + 0.76) / 1.3546; };

	$scope.SRM = function(){ return (1.35465 * $scope.Lovibond) - 0.76; };

}]);