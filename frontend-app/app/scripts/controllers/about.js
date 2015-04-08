'use strict';

/**
 * @ngdoc function
 * @name shoppyApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the shoppyApp
 */
angular.module('shoppyApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
