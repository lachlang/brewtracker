/*
 * Controller search for connection, uploading bulk connections and for sending connection/invitation requests
 */
brewTrackerApp.controller('CalculatorsCtrl', ['$scope', '$log', function($scope, $log) {

	var ctrl = this;

	ctrl.testy = function() {

	};

	ctrl.efficiency = function(){
		$scope.BMA = 0;
		$scope.PPG = 37;
		$scope.batch = 6;
		$scope.gravity = function() {
			return $scope.BMA * $scope.PPG;
		}
	}

	$scope.color = function() {
		$scope.SRM = (1.3546 * $scope.Lovibond) - 0.76;
		$scope.EBC = $scope.SRM * 1.97;
	}
}]);