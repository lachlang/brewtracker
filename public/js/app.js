var btServices = angular.module("brewTracker.services", []);

var btControllers = angular.module("brewTracker.controllers", []);

var brewTrackerApp = angular.module("brewTracker", ["brewTracker.controllers","brewTracker.services"]);