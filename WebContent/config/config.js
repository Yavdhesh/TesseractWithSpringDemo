/**
 * 
 */

angular.module('app').
config(function($provide/*,$routeProvider*/){
 
	// 1.
	$provide.factory('appFactory',function(){
		
	var factoryObject={};
	
	factoryObject.initialFunction=function(obj){
		console.log(obj);
	};
	
	factoryObject.uploadFunc=function(formdata){
		alert('file');
		formdata.append('name', $('input[type=file]')[0].files[0]);

	$.ajax({
	    type: "POST",
	    url: 'http://localhost:8080/BookMyFood/' + "upload",
	    data: formdata,
	    //use contentType, processData for sure.
	    contentType: false,
	    processData: false,
	   /* beforeSend: function() {
	        $('.modal .ajax_data').prepend('<img src="' +
	            base_url +
	            '"asset/images/ajax-loader.gif" />');
	        //$(".modal .ajax_data").html("<pre>Hold on...</pre>");
	        $(".modal").modal("show");
	    },*/
	    success: function(msg) {
	    	console.log(msg)
	        $(".modal .ajax_data").html("<pre>" + msg +
	            "</pre>");
	        $('#close').hide();
	        alert();
	    },
	    error: function() {
	        $(".modal .ajax_data").html(
	            "<pre>Sorry! Couldn't process your request.</pre>"
	        ); // 
	        $('#done').hide();
	        alert();
	    }
	});
	}
	
	
	
		
	return factoryObject;
	});
	
	/*$routeProvider
    .when("/", {
        templateUrl : "main.htm"
    })
    .when("/red", {
        templateUrl : "red.htm"
    })
    .when("/green", {
        templateUrl : "green.htm"
    })
    .when("/blue", {
        templateUrl : "blue.htm"
    });*/
	
});
