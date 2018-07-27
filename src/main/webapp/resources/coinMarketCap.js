/**
 * 
 */


function getData() {
	
	return $.ajax({
	type: "GET",
	async: false,
	url: "/coinMarketCapDataObject",
	dataType: 'json',
	success : function(fulldata) {
		 
		fulldata.sort(function(a,b) {return (parseInt(a.rank) > parseInt(b.rank)) ? 1 : ((parseInt(b.rank) > parseInt(a.rank)) ? -1 : 0);} );
		
		return fulldata;
		/*self.coinMarketCapFullData = ko.observableArray(fulldata);
		
		
		fulldata.forEach(function (data) {
		    data.id = ko.observable(data.id);
		    data.name = ko.observable(data.name);
		    data.market_cap = ko.observable(data.market_cap);
		    data.price = ko.observable(data.price);
		    data.volume_24h = ko.observable(data.volume_24h);
		    data.circulating_supply = ko.observable(data.circulating_supply);
		    data.percent_change_24h = ko.observable(data.percent_change_24h);
		});
		*/			
	}
});
	
	
}


function AppViewModel() {
    var self = this;
    var data = getData().responseJSON;
	self.coinMarketCapFullData = ko.observableArray(data);
	

}


$(document).ready(function() {
	
	var viewmodel = new AppViewModel();
	ko.applyBindings(viewmodel);
   
	 
    setInterval(function(){ 
    	
    	$.ajax({
    		type: "GET",
    		url: "/coinMarketCapDataObject",
    		dataType: 'json',
    		success : function(coinMarketCapFullData) {
    			coinMarketCapFullData.sort(function(a,b) {return (parseInt(a.rank) > parseInt(b.rank)) ? 1 : ((parseInt(b.rank) > parseInt(a.rank)) ? -1 : 0);} );
    			viewmodel.coinMarketCapFullData(coinMarketCapFullData);
    		}
    	});
    	
    }, 10000);
    	
    
    
} );
