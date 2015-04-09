'use strict';

/**
 * @ngdoc function
 * @name shoppyApp.controller:ShoppinglistCtrl
 * @description
 * # ShoppinglistCtrl
 * Controller of the shoppyApp
 */
angular.module('shoppyApp')
  .controller('ShoppinglistCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
