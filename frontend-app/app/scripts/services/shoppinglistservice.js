'use strict';

angular.module('shoppyApp')
  .factory('ShoppingList', function(Restangular) {
    return Restangular.service('shoppinglists');
  });

angular.module('shoppyApp')
  .factory('ShoppingListService', function($q, ShoppingList) {

    return {
      createNewShoppingList: function() {
        var deferred = $q.defer();

        var shoppingList = {};
        ShoppingList.post(shoppingList).then(function(response) {
          var location = response.headers('location');
          var lastSlash = location.lastIndexOf('/');

          deferred.resolve(location.substr(lastSlash + 1));
        });

        return deferred.promise;
      }
    }
  });
