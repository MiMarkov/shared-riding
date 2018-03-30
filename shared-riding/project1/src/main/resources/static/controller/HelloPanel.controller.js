sap.ui.define([
   "sap/ui/core/mvc/Controller", "sap/m/MessageToast", "sap/ui/model/json/JSONModel" ], 
   function (Controller, MessageToast, JSONModel) {
   "use strict";
   return Controller.extend("pack1.controller.HelloPanel", {
      onShowHello : function () {
         // show a native JavaScript alert
    	 var recipient = this.getView().getModel().getProperty("/recipient/name") + " " +
    	 				this.getView().getModel().getProperty("/recipient/secondName");
         MessageToast.show("sup " + recipient);
      }
   });
});