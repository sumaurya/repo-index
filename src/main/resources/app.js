angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get({method: 'JSONP', url : 'http://localhost:8080/availableRepositories'}).
                                                                                     success(function(response) {
                                                                                         //your code when success
                                                                                         $scope.greeting = response['status'];
                                                                                                     console.log($scope.greeting);
                                                                                     }).
                                                                                     error(function(status) {
                                                                                          //your code when fails
                                                                                         console.log(status)
                                                                                     });
        ng build

});