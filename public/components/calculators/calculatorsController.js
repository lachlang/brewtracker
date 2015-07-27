
<!DOCTYPE html>
<html lang="en" class="no-js" id="ng-app" ng-app="brewTrackerApp">
<head>
	<meta charset="utf-8">
	<title>Brew Tracker</title>
	
	<!-- Vieport and Rendering engine related declarations -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">


	<!-- Angularjs -->
	<!-- ========= -->
	<script src="js/libs/angular.min.js"></script>
<!--	<script src="js/libs/angular-animate.min.js"></script>-->
	<script src="js/libs/angular-resource.min.js"></script>
	<script src="js/libs/angular-route.min.js"></script>
	<script src="js/libs/angular-cookies.min.js"></script>

	<!-- 3rd party -->
	<script src="js/libs/ui-bootstrap-tpls-0.13.1.min.js"></script>

	<!-- Brew Tracker -->
	<script src="js/app.js"></script>
	<script src="js/routes.js"></script> 
	<script src="components/landing/loginController.js"></script>
	<script src="components/calculators/calculatorsController.js"></script>
	<script src="components/menu/menuController.js"></script>

	<!-- Flavicon for Bookmarks and Address Bar display	 -->
	<link rel="shortcut icon" href="images/brewtracker-favicon.png">
	
</head>
	<body data-ng-controller="MenuCtrl as menu">
   		<div data-ng-view></div>
		<footer class="page-footer">
			<div class="container body">
				<div class="links">
					<a href="#/about">About Brew Tracker</a>
					<a href="#/terms">Terms of Use</a>
					<a href="#/terms">Privacy Policy</a>
				</div>
				<div class="copyright">
					Copyright &copy; 2015 BrewTracker
				</div>
			</div>
		</footer>
	</body>
</html>
