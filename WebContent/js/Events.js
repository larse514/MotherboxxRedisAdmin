;HTTP = {

	getCacheValue: function(query)
	{
		$.get('http://motherboxxadminui-env.us-west-2.elasticbeanstalk.com/spring/getValue/' + query, 
				function(data, status){
					alert(data + " " + status)
					$('#result').val(data)
				})
	}
	
}
HTTP.getCacheValue();