/**this is the app controller
 * 
 */

angular.module('app')
.controller('appController',function($scope,appFactory){
	
	//initialFunction is for 
	console.log("Inside app controller");
	appFactory.initialFunction("Factory Injected");
	
	var formData = new FormData($('#upload_form')[0]);
    
	$scope.upload=function(){
		alert();
		appFactory.uploadFunc(formData);
	}
	
});