'use strict';

angular.module('shoppyApp')
  .factory('ShoppingListService', function (pouchDB) {

    var db = pouchDB('shoppingLists');

    return {
      createShoppingList: function() {
        var shoppingList = {
          'items': []
        };
        shoppingList.items.push('Milk');
        return db.post(shoppingList);
      }
    };
  });
