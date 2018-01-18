/**
 * 
 */

var cartApp = angular.module("cartApp",[]);
cartApp.controller("cartCtrl",function($scope,$http){
	
	
	
	
	$scope.refreshCart = function(cartId){
		
		$http.get('http://localhost:7979/RACEDYNAMICS/rest/cart/'+$scope.cartId).success(function(data){
			$scope.cart=data;
		});
	};
  
	$scope.clearCart=function(){
	$http.delete('http://localhost:7979/RACEDYNAMICS/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
		};
	
  $scope.initCartId = function(cartId){
	  $scope.cartId= cartId;
	  $scope.refreshCart(cartId);
  };
  
  $scope.addToCart = function(productId){
	  $http.put('http://localhost:7979/RACEDYNAMICS/add/'+productId).success(function(data){
		  $scope.refreshCart($http.get('http://localhost:7979/RACEDYNAMICS/rest/cart/cartId'));
		  alert('product succesfully added to the cart!')
	  });
  };

  $scope.removeFromCart = function(productId){
	  $http.put('http://localhost:7979/RACEDYNAMICS/rest/cart/remove/'+productId).success(function(data){
      $scope.refreshCart($http.get('http://localhost:7979/RACEDYNAMICS/rest/cart/cartId')); 
	  }); 
}; 
});
  