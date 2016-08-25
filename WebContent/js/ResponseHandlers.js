;RESPONSE = {

	handleSuccess: function(data, status){
		alert(data + " " + status)
		$('#result').val(data)
	},
	handleError: function(data, status){
		alert('Value not found'); //or whatever
		$('#result').val('')
	},
	handleStatus: function(data, status){
		alert(data + "Up " + status);
		
	},
	handleKeys: function(data, status){
		alert(data + " keys in cache ");
		
	}
}
