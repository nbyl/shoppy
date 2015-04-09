'use strict';

angular
  .module('shoppyApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'pouchdb'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/shoppingList/:shoppingListId', {
        templateUrl: 'views/shoppinglist.html',
        controller: 'ShoppinglistCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
