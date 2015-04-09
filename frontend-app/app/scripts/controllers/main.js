'use strict';

angular.module('shoppyApp')
  .controller('MainCtrl', function ($scope, $location, ShoppingListService) {
    $scope.createNewShoppingList = function() {
      ShoppingListService.createShoppingList().then(function(response) {
        $location.path('/shoppingList/' + response.id);
      });
    };
  });
