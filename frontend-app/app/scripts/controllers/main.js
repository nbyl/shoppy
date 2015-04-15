'use strict';

angular.module('shoppyApp')
  .controller('MainCtrl', function ($scope, $location, ShoppingListService) {

    $scope.createNewShoppingList = function() {
      ShoppingListService.createNewShoppingList().then(function(id) {
        $location.path('/shoppingList/' + id);
      });
    };

  });
