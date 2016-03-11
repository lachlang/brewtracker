/*
    app controller for all the brew calculators
*/

var app = angular.module('calculators',[]);
app.controller('efficiency',function($scope)){
        $scope.BMA = 10;
        $scope.PPG = 37;
        $scope.batch = 6;
        $scope.gravity = function(){
        return $scope.BMA * $scope.PPG / $scope.batch;
    }

}