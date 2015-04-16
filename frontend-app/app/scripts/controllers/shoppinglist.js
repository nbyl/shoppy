'use strict';

angular.module('shoppyApp')
  .controller('ShoppinglistCtrl', function ($scope, $routeParams, $location, growl, ShoppingListService) {

    $scope.shoppingListId = $routeParams.shoppingListId;

    $scope.shoppingListLocation = $location.absUrl();

    ShoppingListService.getShoppingList($scope.shoppingListId).then(function(shoppingList) {
      $scope.shoppingList = shoppingList;
    });

    $scope.saveShoppingList = function(){
      ShoppingListService.saveShoppingList($scope.shoppingList).then(function() {
        growl.info('Shopping list saved.');
      }).catch(function(err) {
        growl.error('Saving shopping list failed:' + err.message);
      });
    };

    $scope.toggleItemDone = function(item) {
      item.done = !item.done;
      $scope.saveShoppingList();
    };

    $scope.addItem = function() {
      var item = {
        'name': $scope.itemToAdd
      };
      $scope.shoppingList.items.push(item);
      $scope.saveShoppingList();
    };

    $scope.sendShoppingList = function() {
      ShoppingListService.sendShoppingList($scope.shoppingList, $scope.recipient).then(function() {
        growl.success('Mail send to ' + $scope.recipient);
      });
    };
  });
