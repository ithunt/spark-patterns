/**
 * Created by shekhargulati on 10/06/14.
 */

var app = angular.module('messagesapp', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'
]);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'views/list.html',
        controller: 'ListCtrl'
    }).when('/create', {
            templateUrl: 'views/create.html',
            controller: 'CreateCtrl'
        }).otherwise({
            redirectTo: '/'
        })
});

app.controller('ListCtrl', function ($scope, $http) {
    $http.get('/messages').success(function (data) {
        $scope.messages = data;
    }).error(function (data, status) {
            console.log('Error ' + data)
        })

    $scope.messageStatusChanged = function (message) {
        console.log(message);
        $http.put('/messages/' + message.id, message).success(function (data) {
            console.log('status changed');
        }).error(function (data, status) {
                console.log('Error ' + data)
            })
    }
});

app.controller('CreateCtrl', function ($scope, $http, $location) {
    $scope.message = {
    };

    $scope.createMessage = function () {
        console.log($scope.message);
        $http.post('/messages', $scope.message).success(function (data) {
            $location.path('/');
        }).error(function (data, status) {
                console.log('Error ' + data)
            })
    }
});