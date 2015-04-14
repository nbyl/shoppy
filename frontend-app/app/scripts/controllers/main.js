'use strict';

angular.module('shoppyApp')
  .controller('MainCtrl', function ($scope, $location, ShoppingList ) {

    $scope.createNewShoppingList = function() {
      var shoppingList = {};

      ShoppingList.post(shoppingList).then(function(response) {
        console.log(response);
        //$location.path('/shoppingList/' + response.id);
      });
    };

  });
