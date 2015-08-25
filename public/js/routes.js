brewTrackerApp.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.when('/about', {
			templateUrl: 'fragments/about.html',
			requireLogin: false
		});
		// $routeProvider.when('/activationRequired', {
		// 	templateUrl: 'fragments/activationRequired.html',
		// 	controller: 'ActivationRequiredCtrl',
		// 	requireLogin: false
		// });
		//$routeProvider.when('/calculators', {
		//	templateUrl: 'components/calculators/calculators.html',
		//	requireLogin: false
		//});
		$routeProvider.when('/calculators', {
        			templateUrl: 'components/calculators/calculators.html',
        			requireLogin: false
        });
        $routeProvider.when('/error', {
			templateUrl: 'components/error.html',
			requireLogin: false
		});
		// $routeProvider.when('/forgotten', {
		// 	templateUrl: 'fragments/passwordForgotten.html',
		// 	requireLogin: false
		// });
		$routeProvider.when('/landing', {
			templateUrl: 'components/landing/landing.html',
			requireLogin: false
		});
		$routeProvider.when('/list', {
			templateUrl: 'components/list/list.html',
			requireLogin: true
		});
		// $routeProvider.when('/initialise', {
		// 	templateUrl: 'fragments/loading.html',
		// 	controller: 'InitialiseModelCtrl',
		// 	requireLogin: true
		// });
		// $routeProvider.when('/passwordForgottenChange', {
		// 	templateUrl: 'fragments/passwordChange.html',
		// 	controller: 'ForgottenPasswordChangeCtrl',
		// 	requireLogin: true
		// });
		// $routeProvider.when('/passwordForgotten', {
		// 	templateUrl: 'fragments/passwordForgotten.html',
		// 	controller: 'ForgottenPasswordRequestCtrl',
		// 	requireLogin: false
		// });
		// $routeProvider.when('/passwordForgottenSent', {
		// 	templateUrl: 'fragments/passwordForgottenSent.html',
		// 	requireLogin: false
		// });
		// $routeProvider.when('/passwordSet', {
		// 	templateUrl: 'fragments/passwordSet.html',
		// 	requireLogin: true
		// });
		$routeProvider.when('/profile', {
			templateUrl: 'components/profile.html',
			requireLogin: true
		});
		// $routeProvider.when('/register', {
		// 	templateUrl: 'fragments/register.html',
		// 	requireLogin: false
		// });
		// $routeProvider.when('/searchResults', {
		// 	templateUrl: 'fragments/searchResults.html',
		// 	requireLogin: true
		// });
		$routeProvider.when('/signOut', {
			templateUrl: 'components/landing/landing.html',
			requireLogin: false
		});
		$routeProvider.when('/terms', {
			templateUrl: 'fragments/termsAndConditions.html',
			requireLogin: false
		});
		$routeProvider.otherwise({
			redirectTo: '/landing'
		});
	}
]);