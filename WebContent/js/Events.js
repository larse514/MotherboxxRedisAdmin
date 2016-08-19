;HTTP = {

	getCacheValue: function(query)
	{
		$.ajax({
		    url: 'http://motherboxxadminui-env.us-west-2.elasticbeanstalk.com/spring/getValue/' + query,
		    type: 'GET',
		    success: RESPONSE.handleSuccess,
		    error: RESPONSE.handleError
		});
	},
	
	healthCheck: function(isAlive)
	{
		$.ajax({
		    url: 'http://motherboxxadminui-env.us-west-2.elasticbeanstalk.com/spring/getValue/' + isAlive,
		    type: 'GET',
		    success: RESPONSE.handleSuccess,
		    error: RESPONSE.handleError
	},

	addCacheValue: function(data)
	{
		$.ajax({
		    url: 'http://motherboxxadminui-env.us-west-2.elasticbeanstalk.com/spring/getValue/' + query,
		    type: 'POST',
		    data: data,
		    success: RESPONSE.handleSuccess,
		    error: RESPONSE.handleError
		});
	}

}
