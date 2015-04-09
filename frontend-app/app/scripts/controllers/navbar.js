'use strict';

/**
 * @ngdoc function
 * @name shoppyApp.controller:NavbarcontrollerCtrl
 * @description
 * # NavbarcontrollerCtrl
 * Controller of the shoppyApp
 */
angular.module('shoppyApp')
  .controller('NavbarCtrl', function ($scope, $location, growl, ShoppingListService) {
    $scope.loadShoppingList = function() {
      ShoppingListService.getShoppingList($scope.shoppingListId).then(function() {
        $location.path('/shoppingList/' + $scope.shoppingListId);
        $scope.shoppingListId = null;
        growl.success('Loaded shopping list.');
      }).catch(function(err) {
        growl.error('Loading shopping list failed: ' + err.message);
      });
    };
  });
