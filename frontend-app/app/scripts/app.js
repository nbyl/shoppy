'use strict';

angular
  .module('shoppyApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'angular-growl',
    'restangular',
    'pouchdb'
  ]);

angular.module('shoppyApp')
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

angular.module('shoppyApp')
  .config(function (RestangularProvider) {
    RestangularProvider.setBaseUrl('/api');

    // Set an interceptor in order to parse the API response
    // when getting a list of resources
    RestangularProvider.setResponseInterceptor(function(data, operation, what) {
      if (operation === 'getList') {
        var resp;
        resp =  data._embedded[what];
        resp._links = data._links;
        return resp;
      }
      return data;
    });

    // Using self link for self reference resources
    RestangularProvider.setRestangularFields({
      selfLink: 'self.link'
    });
  });
