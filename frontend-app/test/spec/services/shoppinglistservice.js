'use strict';

describe('Service: ShoppingListService', function () {

  // load the service's module
  beforeEach(module('shoppyApp'));

  // instantiate service
  var ShoppingListService;
  beforeEach(inject(function (_ShoppingListService_) {
    ShoppingListService = _ShoppingListService_;
  }));

  it('should do something', function () {
    expect(!!ShoppingListService).toBe(true);
  });

});
