btServices.service('Errors', ['$http', '$log', function($http, $log){
    return {

        REGISTER_EMAIL_DUP_CODE         : 3001,
        REGISTER_EMAIL_DUP_MESSAGE      : "This email address is already in use.  Please try another email address or click here to retrieve your password.",
        REGISTER_FAILED_MESSAGE         : "We cannot register you at this time.  Please try again later.",

    }
}]);