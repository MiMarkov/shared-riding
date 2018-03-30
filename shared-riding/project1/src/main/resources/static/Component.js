sap.ui.define([
   "sap/ui/core/UIComponent",
   "sap/ui/model/json/JSONModel",
   "sap/ui/model/resource/ResourceModel"
], function (UIComponent, JSONModel, ResourceModel) {
   "use strict";
   return UIComponent.extend("pack1.Component", {
            metadata : {
		rootView: {
			"viewName": "pack1.view.App",
			"type": "XML",
			"async": true,
			"id": "app"
		}
	},
      init : function () {
         // call the init function of the parent
         UIComponent.prototype.init.apply(this, arguments);
         // set data model
         //var oData = {
         //   recipient : {
         //      name : "World", 
         //      secondName: "<second>"
         //   }
         //};
         //var oModel = new JSONModel(oData);
         //this.setModel(oModel);
         
         var dataModel = new JSONModel();
		 dataModel.loadData("http://localhost:8080/api/users?mode=ui5", null, true, "GET");
		 console.log(dataModel);
		 this.setModel(dataModel);
      }
   });
});