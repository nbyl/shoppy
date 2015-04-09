'use strict';

angular.module('shoppyApp')
  .controller('ShoppinglistCtrl', function ($scope, $routeParams, $location) {
    $scope.shoppingListId = $routeParams.shoppingListId;

    $scope.shoppingListLocation = $location.absUrl();

  });
