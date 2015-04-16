'use strict';

angular.module('shoppyApp')
  .factory('ShoppingListService', function($q, Restangular) {

    var baseShoppingLists = Restangular.all('shoppinglists');

    return {
      createNewShoppingList: function() {
        var deferred = $q.defer();

        var shoppingList = {
          items: [
            {
              'name': 'Milk'
            }
          ]
        };
        baseShoppingLists.post(shoppingList).then(function(response) {
          var location = response.headers('location');
          var lastSlash = location.lastIndexOf('/');

          deferred.resolve(location.substr(lastSlash + 1));
        });

        return deferred.promise;
      },
      getShoppingList: function(id) {
        var deferred = $q.defer();

        Restangular.one('shoppinglists', id).get().then(function(response) {
          deferred.resolve(response.data);
        });

        return deferred.promise;
      },
      saveShoppingList: function(shoppingList) {
        return shoppingList.put();
      },
      sendShoppingList: function(shoppingList, email) {
        var recipient  = {
          'email': email
        };

        return shoppingList.post('send', recipient);
      }
    };
  });
