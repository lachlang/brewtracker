/*
 * Controller search for connection, uploading bulk connections and for sending connection/invitation requests
 */
brewTrackerApp.controller('CalculatorsCtrl', ['$scope', '$log', function($scope, $log) {

	var ctrl = this;

	ctrl.testy = function() {

	};

	$scope.BMA = 10;
	$scope.PPG = 37;
	$scope.batch = 6;
	$scope.gravity = function(){
		return $scope.BMA * $scope.PPG / $scope.batch;
	}

	this.bma = 10;
	this.grist = 3;
	this.batch = 6;
	this.gravityValue = this.bma * this.grist / this.batch;
}]);