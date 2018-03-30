sap.ui.define([
   "sap/ui/core/mvc/Controller", "sap/ui/model/json/JSONModel" ], 
   function (Controller, JSONModel) {
   "use strict";
   return Controller.extend("pack1.controller.UserList", {
	   
	   onInit : function()
	   {
		   // gets the data from the REST service
		   // it needs to use the mode=ui5 because it cannot fill the list from an array of strings
		   var dataModel = new JSONModel();
		   dataModel.loadData("http://localhost:8080/api/users?mode=ui5", null, true, "GET");
		   this.getView().setModel(dataModel, "userData");
	   }
	   
	   
   });
});