'use strict';

angular.module('shoppyApp')
  .controller('ShoppinglistCtrl', function ($scope, $routeParams, $location, ShoppingListService) {
    $scope.shoppingListId = $routeParams.shoppingListId;

    $scope.shoppingListLocation = $location.absUrl();

    ShoppingListService.getShoppingList($scope.shoppingListId).then(function(shoppingList) {
      $scope.shoppingList = shoppingList;
    });

    $scope.saveShoppingList = function(){
      ShoppingListService.saveShoppingList($scope.shoppingList).then(function() {
        console.log('list saved');
      });
    };
  });
