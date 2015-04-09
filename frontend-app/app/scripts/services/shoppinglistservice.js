'use strict';

angular.module('shoppyApp')
  .factory('ShoppingListService', function (pouchDB) {

    var db = pouchDB('shoppingLists');

    return {
      createShoppingList: function() {
        var shoppingList = {
          'items': []
        };
        shoppingList.items.push({'name': 'Milk'});
        return db.post(shoppingList);
      },
      getShoppingList: function(id) {
        return db.get(id);
      },
      saveShoppingList: function(shoppingList) {
        return db.put(shoppingList);
      }
    };
  });
