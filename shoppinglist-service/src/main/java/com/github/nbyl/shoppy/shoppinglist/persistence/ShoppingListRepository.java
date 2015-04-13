package com.github.nbyl.shoppy.shoppinglist.persistence;


import com.github.nbyl.shoppy.shoppinglist.domain.ShoppingList;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "shoppinglist", path = "shoppinglists")
public interface ShoppingListRepository extends PagingAndSortingRepository<ShoppingList, Integer> {
}
