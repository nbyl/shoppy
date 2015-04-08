'use strict';

/**
 * @ngdoc function
 * @name shoppyApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the shoppyApp
 */
angular.module('shoppyApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
