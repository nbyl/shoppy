'use strict';

angular.module('shoppyApp')
  .factory('ShoppingList', function(Restangular) {
    return Restangular.service('shoppinglists');
  });
